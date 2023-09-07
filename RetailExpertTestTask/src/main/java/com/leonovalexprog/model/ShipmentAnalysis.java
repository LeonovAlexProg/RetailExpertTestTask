package com.leonovalexprog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentAnalysis {
    private String chainName;
    private String category;
    private Integer month;
    private Integer quantity;
    private String shipmentType;
}
