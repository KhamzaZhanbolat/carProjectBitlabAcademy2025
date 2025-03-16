package com.example.CarProject.service;

import com.example.CarProject.dto.HomePageDto;

import java.util.List;

public interface HomePageService {

    List<HomePageDto> getAllHomePages();
    HomePageDto getById(Long id);
    HomePageDto create(HomePageDto homePageDto);
    HomePageDto update(Long id, HomePageDto homePageDto);
    void delete(Long id);
}
