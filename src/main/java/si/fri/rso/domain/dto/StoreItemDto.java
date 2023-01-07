package si.fri.rso.domain.dto;

public class StoreItemDto {

    String gameToCompareId;
    String gameId;
    String name;
    Float price;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getGameToCompareId() {
        return gameToCompareId;
    }

    public void setGameToCompareId(String gameToCompareId) {
        this.gameToCompareId = gameToCompareId;
    }
}
