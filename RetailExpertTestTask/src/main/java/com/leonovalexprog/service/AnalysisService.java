package com.leonovalexprog.service;

import com.leonovalexprog.dto.ShipmentAnalysisDto;

import java.util.List;

public interface AnalysisService {
    List<ShipmentAnalysisDto> calculateFullAnalysis(long page, long size);
}
