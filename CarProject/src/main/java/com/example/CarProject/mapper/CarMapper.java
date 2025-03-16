package com.example.CarProject.mapper;

import com.example.CarProject.dto.CarDto;
import com.example.CarProject.model.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "category.id", target = "categoryId")
    CarDto toDto(CarEntity car);

    CarEntity toEntity(CarDto carDto);

    List<CarDto> toDtoList(List<CarEntity> carEntityList);
}
