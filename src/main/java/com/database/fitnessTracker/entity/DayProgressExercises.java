package com.database.fitnessTracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DayProgress_Exercises")
public class DayProgressExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_DayProgress", nullable = false)
    private DayProgress dayProgress;

    @ManyToOne
    @JoinColumn(name = "id_Exercises", nullable = false)
    private Exercises exercises;

    @Column(name = "execution_time", nullable = false, updatable = false)
    private LocalTime executionTime;
}
