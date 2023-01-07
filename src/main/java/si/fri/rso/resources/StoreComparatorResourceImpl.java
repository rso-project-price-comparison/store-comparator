package si.fri.rso.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import si.fri.rso.domain.StoreComparator;
import si.fri.rso.domain.dto.StoreComparisonDto;
import si.fri.rso.entities.GameToCompareEntity;
import si.fri.rso.repositories.GameToCompareRepository;
import si.fri.rso.services.dtos.StoreEnum;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class StoreComparatorResourceImpl implements StoreComparatorResource {

    @Inject
    public GameToCompareRepository gameToCompareRepository;

    @Inject
    public StoreComparator storeComparator;

    private static final Marker ENTRY_MARKER = MarkerFactory.getMarker("ENTRY");
    private static final Marker OUT_MARKER = MarkerFactory.getMarker("OUT");

    Logger log = LoggerFactory.getLogger(StoreComparatorResourceImpl.class);

    @Override
    public GameToCompareEntity createGameToCompare(GameToCompareEntity gameToCompareEntity) {
        log.info(ENTRY_MARKER, "Calling store comparator service: create game to compare...");
        GameToCompareEntity result = gameToCompareRepository.createGameToCompare(gameToCompareEntity);
        log.info(OUT_MARKER, "Calling store comparator service: game to compare successfully created.");
        return result;
    }

    @Override
    public void removeGameToCompare(Long id) {
        log.info(ENTRY_MARKER, "Calling store comparator service: remove game to compare...");
        gameToCompareRepository.removeGameToCompare(id);
        log.info(OUT_MARKER, "Calling store comparator service: game to compare successfully removed.");
    }

    public List<StoreComparisonDto> compareStores(String sessionId, StoreEnum favouriteStore) {
        log.info(ENTRY_MARKER, "Calling store comparator service:  compare stores...");
        List<StoreComparisonDto> result = storeComparator.compareStores(sessionId, favouriteStore);
        log.info(OUT_MARKER, "Calling store comparator service: game to compare compared.");
        return result;
    }


}
