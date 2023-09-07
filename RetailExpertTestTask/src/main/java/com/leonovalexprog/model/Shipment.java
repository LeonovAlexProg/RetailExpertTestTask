package com.leonovalexprog.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "prod_id", nullable = false)
    private Product products;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "shipment_type")
    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    private enum ShipmentType {
        REGULAR,
        PROMO
    }
}
