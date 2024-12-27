package com.database.fitnessTracker.repository;

import com.database.fitnessTracker.entity.DayProgress;
import com.database.fitnessTracker.entity.DayProgressExercises;
import com.database.fitnessTracker.entity.Exercises;
import com.database.fitnessTracker.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DayProgressExercisesRepository extends CrudRepository<DayProgressExercises, Integer>{

    Optional<DayProgressExercises> findByDayProgressAndExercises(DayProgress dayProgress, Exercises exercises);

    List<DayProgressExercises> findByDayProgress(DayProgress dayProgress);
}
