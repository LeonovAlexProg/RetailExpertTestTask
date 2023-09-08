package com.leonovalexprog.model.projection;

public interface ShipmentAnalysisProjection {
    String getChainName();
    String getCategory();
    Integer getDate();
    Float getRegularQuantity();
    Float getPromoQuantity();
}
