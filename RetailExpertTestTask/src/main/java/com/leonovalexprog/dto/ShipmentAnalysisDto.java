package com.leonovalexprog.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentAnalysisDto {
    private String chainName;
    private String category;
    private String month;
    private Integer promoQuantity;
    private Integer promoPercent;
}
