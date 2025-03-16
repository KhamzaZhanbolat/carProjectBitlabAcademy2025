package com.example.CarProject.service.impl;

import com.example.CarProject.dto.CarDto;
import com.example.CarProject.mapper.CarMapper;
import com.example.CarProject.model.CarCategoryEntity;
import com.example.CarProject.model.CarEntity;
import com.example.CarProject.repository.CarCategoryRepository;
import com.example.CarProject.repository.CarRepository;
import com.example.CarProject.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarCategoryRepository carCategoryRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarDto> getAllCars() {
        return carMapper.toDtoList(carRepository.findAll());
    }

    @Override
    public CarDto getById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Машина не найдена с ID: " + id));
    }

    @Override
    public CarDto create(CarDto carDto) {
        CarEntity car = new CarEntity();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setTypeEngine(carDto.getTypeEngine());
        car.setEngine(carDto.getEngine());
        car.setTransmission(carDto.getTransmission());
        car.setPrice(carDto.getPrice());
        car.setColor(carDto.getColor());
        car.setDescription(carDto.getDescription());
        car.setDescriptionPrice(carDto.getDescriptionPrice());

        CarCategoryEntity category = carCategoryRepository.findById(carDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));
        car.setCategory(category);

        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public CarDto update(Long id, CarDto carDto) {
        CarEntity car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Машина не найдена"));

        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setPrice(carDto.getPrice());
        car.setColor(carDto.getColor());
        car.setEngine(carDto.getEngine());
        car.setDescription(carDto.getDescription());
        car.setDescriptionPrice(carDto.getDescriptionPrice());
        car.setTransmission(carDto.getTransmission());
        car.setTypeEngine(carDto.getTypeEngine());

        if (carDto.getCategoryId() != null) {
            CarCategoryEntity category = carCategoryRepository.findById(carDto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Категория не найдена"));
            car.setCategory(category);
        }

        return carMapper.toDto(carRepository.save(car));
    }


    @Override
    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Машина с ID " + id + " не найдена");
        }
        carRepository.deleteById(id);
    }
}
