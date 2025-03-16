package com.example.CarProject.repository;

import com.example.CarProject.model.CarCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategoryEntity, Long> {
}
