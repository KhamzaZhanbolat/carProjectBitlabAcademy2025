package com.example.CarProject.service.impl;

import com.example.CarProject.dto.CarCategoryDto;
import com.example.CarProject.mapper.CarCategoryMapper;
import com.example.CarProject.model.CarCategoryEntity;
import com.example.CarProject.repository.CarCategoryRepository;
import com.example.CarProject.service.CarCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarCategoryServiceImpl implements CarCategoryService {

    private final CarCategoryRepository carCategoryRepository;
    private final CarCategoryMapper carCategoryMapper;

    @Override
    public List<CarCategoryDto> getAll() {
        return carCategoryRepository.findAll().stream()
                .map(carCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarCategoryDto getByIdCategory(Long id) {
        CarCategoryEntity carCategoryEntity = carCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));
        return carCategoryMapper.toDto(carCategoryEntity);
    }

    @Override
    public CarCategoryDto createCategory(CarCategoryDto carCategoryDto) {
        return carCategoryMapper.toDto(carCategoryRepository.save(carCategoryMapper.toEntity(carCategoryDto)));
    }

    @Override
    public CarCategoryDto updateCategory(Long id, CarCategoryDto carCategoryDto) {
        CarCategoryEntity categoryEntity = carCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));
        categoryEntity.setName(carCategoryDto.getName());
        return carCategoryMapper.toDto(carCategoryRepository.save(categoryEntity));
    }


    @Override
    public void delete(Long id) {
        carCategoryRepository.deleteById(id);
    }
}
