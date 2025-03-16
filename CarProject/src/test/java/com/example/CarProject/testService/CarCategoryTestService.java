package com.example.CarProject.testService;

import com.example.CarProject.dto.CarCategoryDto;
import com.example.CarProject.service.impl.CarCategoryServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class CarCategoryTestService {

    @Autowired
    private CarCategoryServiceImpl carCategoryService;

    @Test
    void testCreateAndGetCategory() {
        CarCategoryDto carCategoryDto = new CarCategoryDto();
        carCategoryDto.setName("Эконом");

        CarCategoryDto savedCategory = carCategoryService.createCategory(carCategoryDto);
        assertNotNull(savedCategory);

        CarCategoryDto retrievedCategory = carCategoryService.getByIdCategory(savedCategory.getId());
        assertEquals("Эконом", retrievedCategory.getName());
    }
}
