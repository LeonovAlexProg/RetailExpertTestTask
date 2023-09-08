package com.leonovalexprog.repository;

import com.leonovalexprog.dto.ShipmentAnalysisDto;
import com.leonovalexprog.model.Shipment;
import com.leonovalexprog.model.ShipmentAnalysis;
import com.leonovalexprog.model.projection.ShipmentAnalysisProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    @Query(value = "SELECT chain_name AS \"chainName\", category, \"month\", SUM(reg_q) AS \"regularQuantity\", SUM(prom_q) AS \"promoQuantity\" FROM " +
            "(SELECT pr.chain_name, p.category, MONTH(s.date) AS \"month\", CASE WHEN s.shipment_type = 'REGULAR' THEN SUM(s.quantity) ELSE 0 END AS \"REG_Q\",  CASE WHEN s.shipment_type = 'PROMO' THEN SUM(s.quantity) ELSE 0 END AS \"PROM_Q\",  s.shipment_type " +
            "FROM shipments AS s " +
            "JOIN products AS p ON p.id = s.prod_id " +
            "JOIN prices AS pr ON pr.id = s.reg_price_id " +
            "GROUP BY pr.chain_name, p.category, s.date, s.shipment_type) " +
            "GROUP BY chain_name, category, \"month\"", nativeQuery = true)
    List<ShipmentAnalysisProjection> getFullShipmentAnalysis();
}
