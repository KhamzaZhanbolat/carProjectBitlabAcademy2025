package com.example.CarProject.repository;

import com.example.CarProject.model.HomePageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HomePageEntity, Long> {
}
