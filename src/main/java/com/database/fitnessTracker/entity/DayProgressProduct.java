package com.database.fitnessTracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DayProgress_Product")
public class DayProgressProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_DayProgress", nullable = false)
    private DayProgress dayProgress;

    @ManyToOne
    @JoinColumn(name = "id_Product", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "grams_of_product")
    private Double gramsOfProduct;

    @NotNull
    @Column(name = "meal")
    private Meal meal;
}
