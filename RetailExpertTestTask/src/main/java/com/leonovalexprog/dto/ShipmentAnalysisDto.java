package com.leonovalexprog.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentAnalysisDto {
    private String chainName;
    private String category;
    private Integer month;
    private Integer regularQuantity;
    private Integer promoQuantity;
    private Float promoPercent;
}
