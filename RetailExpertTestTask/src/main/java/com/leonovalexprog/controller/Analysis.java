package com.leonovalexprog.controller;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.dto.ShipmentDailyAnalysisDto;
import com.leonovalexprog.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Analysis {
    private final AnalysisService analysisService;

    @GetMapping("/analysis")
    public List<ShipmentAnalysisDto> getFullAnalysis(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        log.info("Get shipment analysis (page = {}, size = {})", page, size);

        return analysisService.calculateFullAnalysis(page, size);
    }

    @GetMapping("/analysis/daily")
    public List<ShipmentDailyAnalysisDto> getFullDailyAnalysis(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        log.info("Get shipment analysis (page = {}, size = {})", page, size);

        return analysisService.calculateFullDailyAnalysis(page, size);
    }
}
