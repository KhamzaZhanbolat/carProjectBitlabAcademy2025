package com.example.CarProject.service.impl;

import com.example.CarProject.dto.HomePageDto;
import com.example.CarProject.mapper.HomePageMapper;
import com.example.CarProject.repository.HomeRepository;
import com.example.CarProject.service.HomePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomePageServiceImpl implements HomePageService {

    private final HomeRepository homeRepository;
    private final HomePageMapper homePageMapper;

    @Override
    public List<HomePageDto> getAllHomePages() {
        return homePageMapper.toDtoList(homeRepository.findAll());
    }

    @Override
    public HomePageDto getById(Long id) {
        return homePageMapper.toDto(homeRepository.findById(id).orElse(null));
    }

    @Override
    public HomePageDto create(HomePageDto homePageDto) {
        return homePageMapper.toDto(homeRepository.save(homePageMapper.toEntity(homePageDto)));
    }

    @Override
    public HomePageDto update(Long id, HomePageDto homePageDto) {
        HomePageDto home = getById(id);
        home.setDescription(homePageDto.getDescription());
        home.setAddress(homePageDto.getAddress());
        home.setEmail(homePageDto.getEmail());
        home.setNumbers(homePageDto.getNumbers());
        return homePageMapper.toDto(homeRepository.save(homePageMapper.toEntity(home)));

    }

    @Override
    public void delete(Long id) {
        homeRepository.deleteById(id);
    }
}
