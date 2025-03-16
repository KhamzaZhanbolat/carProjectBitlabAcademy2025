package com.example.CarProject.service;

import com.example.CarProject.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAllCars();
    CarDto getById(Long id);
    CarDto create(CarDto carDto);
    CarDto update(Long id, CarDto carDto);
    void delete(Long id);

}
