package com.example.CarProject.service;

import com.example.CarProject.dto.CarCategoryDto;

import java.util.List;

public interface CarCategoryService {

    List<CarCategoryDto> getAll();
    CarCategoryDto getByIdCategory(Long id);
    CarCategoryDto createCategory(CarCategoryDto carCategoryDto);
    CarCategoryDto updateCategory(Long id, CarCategoryDto carCategoryDto);
    void delete(Long id);
}
