package com.leonovalexprog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDailyAnalysisDto {
    private String chainName;
    private String category;
    private Integer day;
    private Integer regularQuantity;
    private Integer promoQuantity;
    private Float promoPercent;
}
