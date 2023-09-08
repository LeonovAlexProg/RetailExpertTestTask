package com.leonovalexprog.service;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.dto.ShipmentDailyAnalysisDto;
import com.leonovalexprog.mapper.ShipmentAnalysisMapper;
import com.leonovalexprog.model.Shipment;
import com.leonovalexprog.model.ShipmentAnalysis;
import com.leonovalexprog.model.projection.ShipmentAnalysisProjection;
import com.leonovalexprog.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<ShipmentAnalysisDto> calculateFullAnalysis(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        List<ShipmentAnalysisProjection> shipmentAnalyzesProjection = shipmentRepository.getFullShipmentAnalysis(pageable);
        List<ShipmentAnalysis> shipmentAnalyses = shipmentAnalyzesProjection.stream()
                .map(projection -> new ShipmentAnalysis(
                        projection.getChainName(),
                        projection.getCategory(),
                        projection.getDate(),
                        projection.getRegularQuantity(),
                        projection.getPromoQuantity()
                ))
                .sorted(Comparator.comparing(ShipmentAnalysis::getDate))
                .toList();

        return shipmentAnalyses.stream()
                .map(ShipmentAnalysisMapper::toDto)
                .toList();
    }

    @Override
    public List<ShipmentDailyAnalysisDto> calculateFullDailyAnalysis(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        List<ShipmentAnalysisProjection> shipmentAnalyzesProjection = shipmentRepository.getDailyShipmentAnalysis(pageable);
        List<ShipmentAnalysis> shipmentAnalyses = shipmentAnalyzesProjection.stream()
                .map(projection -> new ShipmentAnalysis(
                        projection.getChainName(),
                        projection.getCategory(),
                        projection.getDate(),
                        projection.getRegularQuantity(),
                        projection.getPromoQuantity()
                ))
                .sorted(Comparator.comparing(ShipmentAnalysis::getDate))
                .toList();

        return shipmentAnalyses.stream()
                .map(ShipmentAnalysisMapper::toDailyDto)
                .toList();
    }
}
