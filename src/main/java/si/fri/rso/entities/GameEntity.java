package si.fri.rso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "game", schema = "public", catalog = "postgres")
public class GameEntity implements Serializable {
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "gogId", unique = true)
    private String gogId;
    @Column(name = "steamId", unique = true)
    private String steamId;

    public String getGogId() {
        return gogId;
    }

    public void setGogId(String gogId) {
        this.gogId = gogId;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
