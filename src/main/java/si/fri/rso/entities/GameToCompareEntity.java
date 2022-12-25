package si.fri.rso.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gamesToCompare", schema = "public", catalog = "postgres")
public class GameToCompareEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "sessionId", nullable = false)
    private String sessionId;

    @ManyToOne(cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "game_entity_name", nullable = false)
    private GameEntity game;

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
