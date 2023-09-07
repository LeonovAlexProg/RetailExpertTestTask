package com.leonovalexprog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prices")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String chainName;

    @Column(nullable = false)
    private Double price;
}
