package com.leonovalexprog.model.projection;

public interface ShipmentAnalysisProjection {
    String getChainName();
    String getCategory();
    Integer getMonth();
    Float getRegularQuantity();
    Float getPromoQuantity();
}
