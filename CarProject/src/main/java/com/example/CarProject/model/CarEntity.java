package com.example.CarProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String typeEngine;
    private String engine;
    private String transmission;
    private double price;
    private String color;
    private String description;
    private String descriptionPrice;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CarCategoryEntity category;
}
