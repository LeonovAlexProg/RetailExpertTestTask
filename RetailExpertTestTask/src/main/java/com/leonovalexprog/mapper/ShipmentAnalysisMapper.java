package com.leonovalexprog.mapper;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.dto.ShipmentDailyAnalysisDto;
import com.leonovalexprog.model.ShipmentAnalysis;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ShipmentAnalysisMapper {
    public static ShipmentAnalysisDto toDto(ShipmentAnalysis shipmentAnalysis) {
        return ShipmentAnalysisDto.builder()
                .chainName(shipmentAnalysis.getChainName())
                .category(shipmentAnalysis.getCategory())
                .month(shipmentAnalysis.getDate())
                .regularQuantity(Math.round(shipmentAnalysis.getRegularQuantity()))
                .promoQuantity(Math.round(shipmentAnalysis.getPromoQuantity()))
                .promoPercent(
                        shipmentAnalysis.getPromoQuantity() / (shipmentAnalysis.getPromoQuantity() + shipmentAnalysis.getRegularQuantity()) * 100
                )
                .build();
    }

    public static ShipmentDailyAnalysisDto toDailyDto(ShipmentAnalysis shipmentAnalysis) {
        return ShipmentDailyAnalysisDto.builder()
                .chainName(shipmentAnalysis.getChainName())
                .category(shipmentAnalysis.getCategory())
                .day(shipmentAnalysis.getDate())
                .regularQuantity(Math.round(shipmentAnalysis.getRegularQuantity()))
                .promoQuantity(Math.round(shipmentAnalysis.getPromoQuantity()))
                .promoPercent(
                        shipmentAnalysis.getPromoQuantity() / (shipmentAnalysis.getPromoQuantity() + shipmentAnalysis.getRegularQuantity()) * 100
                )
                .build();
    }
}
