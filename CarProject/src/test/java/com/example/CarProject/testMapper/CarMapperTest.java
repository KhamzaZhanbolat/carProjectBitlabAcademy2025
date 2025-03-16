package com.example.CarProject.testMapper;

import com.example.CarProject.dto.CarDto;
import com.example.CarProject.mapper.CarMapper;
import com.example.CarProject.model.CarEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    void testToDto() {
        CarEntity carEntity = new CarEntity();
        carEntity.setId(1L);
        carEntity.setBrand("BMW");

        CarDto carDto = carMapper.toDto(carEntity);

        assertNotNull(carDto);
        assertEquals(1L, carDto.getId());
        assertEquals("BMW", carDto.getBrand());
    }

    @Test
    void testToEntity() {
        CarDto carDto = new CarDto();
        carDto.setId(2L);
        carDto.setBrand("Audi");

        CarEntity carEntity = carMapper.toEntity(carDto);

        assertNotNull(carEntity);
        assertEquals(2L, carEntity.getId());
        assertEquals("Audi", carEntity.getBrand());
    }
}
