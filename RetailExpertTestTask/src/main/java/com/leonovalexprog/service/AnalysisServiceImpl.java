package com.leonovalexprog.service;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.model.Shipment;
import com.leonovalexprog.model.ShipmentAnalysis;
import com.leonovalexprog.model.projection.ShipmentAnalysisProjection;
import com.leonovalexprog.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    private final ShipmentRepository shipmentRepository;

    @Override
    public List<ShipmentAnalysisDto> calculateFullAnalysis(long page, long size) {
        List<ShipmentAnalysisProjection> shipmentAnalyzesProjection = shipmentRepository.getFullShipmentAnalysis();
        List<ShipmentAnalysis> shipmentAnalyses = shipmentAnalyzesProjection.stream()
                .map(projection -> new ShipmentAnalysis(
                        projection.getChainName(),
                        projection.getCategory(),
                        projection.getMonth(),
                        projection.getQuantity(),
                        projection.getShipmentType()
                ))
                .sorted(Comparator.comparing(ShipmentAnalysis::getMonth))
                .toList();

        List<ShipmentAnalysisDto> shipmentAnalysisDtos = new ArrayList<>();

        for (ShipmentAnalysis model : shipmentAnalyses) {

        }
    }
}
