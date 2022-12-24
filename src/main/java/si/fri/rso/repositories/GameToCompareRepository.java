package si.fri.rso.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import si.fri.rso.entities.GameToCompareEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GameToCompareRepository implements PanacheRepository<GameToCompareEntity> {

    public List<GameToCompareEntity> findByUser(String sessionId) {
        return list("sessionId", sessionId);
    }

    @Transactional
    public GameToCompareEntity createGameToCompare(GameToCompareEntity gameToCompareEntity) {
        persist(gameToCompareEntity);
        return gameToCompareEntity;
    }

    @Transactional
    public void removeGameToCompare(Long id) {
        delete("id", id);
    }

}
