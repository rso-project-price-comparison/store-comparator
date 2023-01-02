package si.fri.rso.domain.dto;

import si.fri.rso.services.dtos.StoreEnum;

import java.util.List;

public class StoreComparisonDto {

    StoreEnum store;
    List<StoreItemDto> storeItems;
    Float totalPrice;
    Float totalScore;

    public StoreEnum getStore() {
        return store;
    }

    public void setStore(StoreEnum store) {
        this.store = store;
    }

    public List<StoreItemDto> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(List<StoreItemDto> storeItems) {
        this.storeItems = storeItems;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }
}
