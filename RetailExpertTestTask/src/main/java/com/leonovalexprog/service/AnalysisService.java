package com.leonovalexprog.service;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.dto.ShipmentDailyAnalysisDto;

import java.util.List;

public interface AnalysisService {
    List<ShipmentAnalysisDto> calculateFullAnalysis(int page, int size);

    List<ShipmentDailyAnalysisDto> calculateFullDailyAnalysis(int page, int size);
}
