package com.example.CarProject.testService;

import com.example.CarProject.dto.HomePageDto;
import com.example.CarProject.service.impl.HomePageServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class HomeTestService {

    @Autowired
    private HomePageServiceImpl homePageService;

    @Test
    void testCreateAndGetHomePage() {
        HomePageDto homePageDto = new HomePageDto();
        homePageDto.setDescription("Главная страница");

        HomePageDto savedHomePage = homePageService.create(homePageDto);
        assertNotNull(savedHomePage.getId());

        HomePageDto retrievedHomePage = homePageService.getById(savedHomePage.getId());
        assertEquals("Главная страница", retrievedHomePage.getDescription());
    }
}
