package com.leonovalexprog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prices", uniqueConstraints = {@UniqueConstraint(columnNames = { "chain_name", "price"})})
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chain_name", nullable = false)
    private String chainName;

    @Column(nullable = false)
    private Double price;

    @OneToOne(mappedBy = "price")
    private Product product;
}
