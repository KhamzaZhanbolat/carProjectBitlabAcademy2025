package com.example.CarProject.mapper;

import com.example.CarProject.dto.CarCategoryDto;
import com.example.CarProject.model.CarCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CarMapper.class)
public interface CarCategoryMapper {

    @Mapping(target = "cars", source = "cars")
    CarCategoryDto toDto(CarCategoryEntity carCategoryEntity);

    @Mapping(target = "cars", ignore = true)
    CarCategoryEntity toEntity(CarCategoryDto carCategoryDto);

}
