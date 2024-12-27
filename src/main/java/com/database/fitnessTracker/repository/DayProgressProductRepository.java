package com.database.fitnessTracker.repository;

import com.database.fitnessTracker.entity.DayProgressProduct;
import com.database.fitnessTracker.entity.DayProgress;
import com.database.fitnessTracker.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DayProgressProductRepository extends CrudRepository<DayProgressProduct, Integer> {

    Optional<DayProgressProduct> findByDayProgressAndProduct(DayProgress dayProgress, Product product);

    List<DayProgressProduct> findByDayProgress(DayProgress byId);
}
