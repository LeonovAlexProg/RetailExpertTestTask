package com.leonovalexprog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String brand;

    @OneToOne
    @JoinColumn(name = "price_id")
    private Price price;
}
