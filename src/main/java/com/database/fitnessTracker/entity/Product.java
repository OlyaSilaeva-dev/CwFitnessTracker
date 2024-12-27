package com.database.fitnessTracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "calories")
    private Integer calories;

    @NotNull
    @Column(name = "proteins")
    private Double proteins;

    @NotNull
    @Column(name = "fats")
    private Double fats;

    @NotNull
    @Column(name = "carbohydrates")
    private Double carbohydrates;
}

