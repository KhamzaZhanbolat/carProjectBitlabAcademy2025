package com.example.CarProject.mapper;

import com.example.CarProject.dto.HomePageDto;
import com.example.CarProject.model.HomePageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomePageMapper {

    @Mapping(target = "categoriesLink", expression = "java(\"/categories\")")
    HomePageDto toDto(HomePageEntity homePageEntity);

    HomePageEntity toEntity(HomePageDto homePageDto);

    List<HomePageDto> toDtoList(List<HomePageEntity> homePageEntities);
}
