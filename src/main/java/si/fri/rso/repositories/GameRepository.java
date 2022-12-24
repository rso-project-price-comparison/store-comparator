package si.fri.rso.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import si.fri.rso.entities.GameEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class GameRepository implements PanacheRepository<GameEntity> {

    public GameEntity findByName(String name) {
        return find("name", name).firstResult();
    }

    @Transactional
    public GameEntity createGame(GameEntity game) {
        persist(game);
        return game;
    }
}
