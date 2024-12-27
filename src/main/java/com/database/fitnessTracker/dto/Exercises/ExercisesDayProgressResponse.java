package com.database.fitnessTracker.dto.Exercises;

import com.database.fitnessTracker.entity.DayProgressExercises;
import com.database.fitnessTracker.entity.Intensity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExercisesDayProgressResponse {
    private Integer id;
    private String userName;
    private String exercisesName;
    private Integer exercisesCaloriesPerHour;
    private Intensity exercisesIntensity;
    private LocalTime exercisesExecutingTime;
    private LocalDateTime localDateTime;

    public ExercisesDayProgressResponse(DayProgressExercises dayProgressExercises) {
        this.id = dayProgressExercises.getId();
        this.userName = dayProgressExercises.getDayProgress().getUser().getUsername();
        this.exercisesName = dayProgressExercises.getExercises().getName();
        this.exercisesCaloriesPerHour = dayProgressExercises.getExercises().getCalories();
        this.exercisesIntensity = dayProgressExercises.getExercises().getIntensity();
        this.exercisesExecutingTime = dayProgressExercises.getExecutionTime();
        this.localDateTime = LocalDateTime.now();
    }
}
