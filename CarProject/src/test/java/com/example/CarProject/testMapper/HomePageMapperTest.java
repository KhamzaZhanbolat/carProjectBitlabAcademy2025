package com.example.CarProject.testMapper;

import com.example.CarProject.dto.HomePageDto;
import com.example.CarProject.mapper.HomePageMapper;
import com.example.CarProject.model.HomePageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class HomePageMapperTest {

    @Autowired
    private HomePageMapper homePageMapper;

    @Test
    void testToDto() {
        HomePageEntity entity = new HomePageEntity();
        entity.setId(1L);
        entity.setDescription("Тестовое описание");

        HomePageDto dto = homePageMapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Тестовое описание", dto.getDescription());
    }

    @Test
    void testToEntity() {
        HomePageDto dto = new HomePageDto();
        dto.setId(2L);
        dto.setDescription("Еще одно описание");

        HomePageEntity entity = homePageMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(2L, entity.getId());
        assertEquals("Еще одно описание", entity.getDescription());
    }
}
