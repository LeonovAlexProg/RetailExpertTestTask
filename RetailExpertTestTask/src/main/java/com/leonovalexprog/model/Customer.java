package com.leonovalexprog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String name;
}
