package si.fri.rso.resources;

import si.fri.rso.entities.GameToCompareEntity;
import si.fri.rso.repositories.GameToCompareRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class StoreComparatorResourceImpl implements StoreComparatorResource {

    @Inject
    public GameToCompareRepository gameToCompareRepository;

    @Override
    public GameToCompareEntity createGameToCompare(GameToCompareEntity gameToCompareEntity) {
        return gameToCompareRepository.createGameToCompare(gameToCompareEntity);
    }

    @Override
    public void removeGameToCompare(Long id) {
        gameToCompareRepository.removeGameToCompare(id);
    }

    @Override
    public List<GameToCompareEntity> getGameToCompareByUser(String sessionId) {
        return gameToCompareRepository.findByUser(sessionId);
    }


}
