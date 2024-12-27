package com.database.fitnessTracker.dto.Exercises;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExercisesDayProgressRequest {
    private Integer ExerciseId;
    private Integer UserId;
    private LocalDateTime date;
}