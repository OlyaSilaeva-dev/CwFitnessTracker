package com.database.fitnessTracker.repository;

import com.database.fitnessTracker.entity.DayProgress;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DayProgressRepository extends CrudRepository<DayProgress, Integer> {

    @Override
    Optional<DayProgress> findById(Integer id);

    List<DayProgress> findByDate(LocalDate date);

}
