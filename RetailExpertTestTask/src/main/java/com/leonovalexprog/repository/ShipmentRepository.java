package com.leonovalexprog.repository;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.model.Shipment;
import com.leonovalexprog.model.ShipmentAnalysis;
import com.leonovalexprog.model.projection.ShipmentAnalysisProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    @Query(value = "SELECT pr.chain_name AS \"chainName\", " +
            "p.category AS \"category\", " +
            "MONTH(s.date) AS \"month\", " +
            "SUM(s.quantity) AS \"quantity\", " +
            "s.shipment_type AS \"shipmentType\" " +
            "FROM shipments AS s " +
            "JOIN products AS p ON p.id = s.prod_id " +
            "JOIN prices AS pr ON pr.id = s.reg_price_id " +
            "GROUP BY pr.chain_name, s.shipment_type, s.date", nativeQuery = true)
    List<ShipmentAnalysisProjection> getFullShipmentAnalysis();
}
