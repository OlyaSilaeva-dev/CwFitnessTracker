package com.database.fitnessTracker.repository;

import com.database.fitnessTracker.entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Override
    Optional<Product> findById(Integer id);
}
