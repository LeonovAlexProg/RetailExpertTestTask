package com.leonovalexprog.repository;

import com.leonovalexprog.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
