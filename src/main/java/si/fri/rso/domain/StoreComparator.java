package si.fri.rso.domain;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import si.fri.rso.domain.dto.StoreComparisonDto;
import si.fri.rso.domain.dto.StoreItemDto;
import si.fri.rso.entities.GameToCompareEntity;
import si.fri.rso.repositories.GameToCompareRepository;
import si.fri.rso.services.GameDataService;
import si.fri.rso.services.dtos.GamePriceDto;
import si.fri.rso.services.dtos.PriceRequest;
import si.fri.rso.services.dtos.StoreEnum;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StoreComparator {

    @RestClient
    public GameDataService gameDataService;

    @Inject
    public GameToCompareRepository gameToCompareRepository;

    private static final Marker STORE_COMPARISON_MARKER = MarkerFactory.getMarker("STORE_COMPARISON");

    Logger log = LoggerFactory.getLogger(StoreComparator.class);

    public List<StoreComparisonDto> compareStores(String sessionId, StoreEnum favouriteStore) {

        List<GameToCompareEntity> gamesToCompare = gameToCompareRepository.findByUser(sessionId);

        StoreComparisonDto gogStoreComparison = new StoreComparisonDto();
        gogStoreComparison.setStore(StoreEnum.GOG);
        List<StoreItemDto> gogStoreItems = new ArrayList<>();
        gogStoreComparison.setStoreItems(gogStoreItems);

        StoreComparisonDto steamStoreComparison = new StoreComparisonDto();
        steamStoreComparison.setStore(StoreEnum.STEAM);
        List<StoreItemDto> steamStoreItems = new ArrayList<>();
        steamStoreComparison.setStoreItems(steamStoreItems);

        gamesToCompare.forEach(g -> {
            if (g.getGame().getGogId() != null) {

                try {
                    Optional<GamePriceDto> price = gameDataService.getPrices(Collections.singletonList(new PriceRequest(g.getGame().getGogId(), StoreEnum.GOG))).stream().findFirst();

                    StoreItemDto item = new StoreItemDto();
                    item.setName(g.getGame().getName());
                    item.setGameId(g.getGame().getGogId());
                    item.setGameToCompareId(String.valueOf(g.getId()));
                    price.ifPresent(p -> item.setPrice(p.finalPrice()));

                    if (item.getPrice() == null)
                        item.setPrice(0.0f);

                    gogStoreItems.add(item);
                } catch (Exception e) {
                    // do nothing
                    log.info(STORE_COMPARISON_MARKER, "Something went wrong when fetching price data from GOG.");
                }

            }

            if (g.getGame().getSteamId() != null) {

                try {
                    Optional<GamePriceDto> price = gameDataService.getPrices(Collections.singletonList(new PriceRequest(g.getGame().getSteamId(), StoreEnum.STEAM))).stream().findFirst();

                    StoreItemDto item = new StoreItemDto();
                    item.setName(g.getGame().getName());
                    item.setGameId(g.getGame().getSteamId());
                    item.setGameToCompareId(String.valueOf(g.getId()));
                    price.ifPresent(p -> item.setPrice(p.finalPrice()));

                    if (item.getPrice() == null)
                        item.setPrice(0.0f);

                    steamStoreItems.add(item);
                } catch (Exception e) {
                    // do nothing
                    log.info(STORE_COMPARISON_MARKER, "Something went wrong when fetching price data from STEAM.");
                }

            }

        });

        // total gog price
        Float totalGogPrice = gogStoreComparison.getStoreItems()
                .stream()
                .map(StoreItemDto::getPrice)
                .reduce(0.0f, Float::sum);

        gogStoreComparison.setTotalPrice(totalGogPrice);

        // total steam price
        Float totalSteamPrice = steamStoreComparison.getStoreItems()
                .stream()
                .map(StoreItemDto::getPrice)
                .reduce(0.0f, Float::sum);

        steamStoreComparison.setTotalPrice(totalSteamPrice);

        calculateFinalScores(gogStoreComparison, steamStoreComparison, favouriteStore);

        return List.of(gogStoreComparison, steamStoreComparison);
    }

    private void calculateFinalScores(StoreComparisonDto gogStoreComparison, StoreComparisonDto steamStoreComparison, StoreEnum favouriteStore) {

        Float steamScore = 0.0f;
        Float gogScore = 0.0f;

        if (favouriteStore != null && favouriteStore.equals(StoreEnum.STEAM))
            steamScore += 1;

        if (favouriteStore != null && favouriteStore.equals(StoreEnum.GOG))
            gogScore += 1;

        if (Float.compare(gogStoreComparison.getTotalPrice(), steamStoreComparison.getTotalPrice()) < 0) {
            gogScore += 1;
        } else if (Float.compare(gogStoreComparison.getTotalPrice(), steamStoreComparison.getTotalPrice()) > 0) {
            steamScore += 1;
        }

        gogStoreComparison.setTotalScore(gogScore);
        steamStoreComparison.setTotalScore(steamScore);
    }
}
