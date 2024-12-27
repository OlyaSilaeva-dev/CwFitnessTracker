package com.database.fitnessTracker.repository;

import com.database.fitnessTracker.entity.Exercises;
import com.database.fitnessTracker.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercises, Integer> {

    @Override
    Optional<Exercises> findById(Integer id);
}
