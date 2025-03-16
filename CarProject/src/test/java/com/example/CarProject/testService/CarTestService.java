package com.example.CarProject.testService;

import com.example.CarProject.dto.CarDto;
import com.example.CarProject.model.CarCategoryEntity;
import com.example.CarProject.repository.CarCategoryRepository;
import com.example.CarProject.service.impl.CarServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CarTestService {

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private CarCategoryRepository carCategoryRepository;

    @Test
    void testCreateAndGetCar() {
        CarCategoryEntity category = new CarCategoryEntity();
        category.setName("Эконом");
        CarCategoryEntity savedCategory = carCategoryRepository.save(category);

        CarDto carDto = new CarDto();
        carDto.setBrand("Тойота");
        carDto.setModel("Камри");
        carDto.setPrice(25000);
        carDto.setTransmission("Автомат");
        carDto.setTypeEngine("Бензин");
        carDto.setEngine("2.5л");
        carDto.setDescription("Подробнее об условиях аренды...");
        carDto.setDescriptionPrice("от 1 до 2 суток 200 000тг.");
        carDto.setColor("Белый");
        carDto.setCategoryId(savedCategory.getId());

        CarDto savedCar = carService.create(carDto);
        assertNotNull(savedCar);
        assertNotNull(savedCar.getId());

        CarDto retrievedCar = carService.getById(savedCar.getId());
        assertAll(
                () -> assertEquals("Тойота", retrievedCar.getBrand()),
                () -> assertEquals("Камри", retrievedCar.getModel()),
                () -> assertEquals("Автомат", retrievedCar.getTransmission()),
                () -> assertEquals("Бензин", retrievedCar.getTypeEngine()),
                () -> assertEquals("2.5л", retrievedCar.getEngine()),
                () -> assertEquals("Белый", retrievedCar.getColor()),
                () -> assertEquals(savedCategory.getId(), retrievedCar.getCategoryId())
        );
    }

    @Test
    void testGetAllCars() {
        List<CarDto> cars = carService.getAllCars();
        assertNotNull(cars);
    }

    @Test
    void testDeleteCar() {
        CarDto carDto = new CarDto();
        carDto.setBrand("Тойота");
        carDto.setModel("Камри");
        carDto.setPrice(25000);
        carDto.setTransmission("Автомат");
        carDto.setTypeEngine("Бензин");
        carDto.setEngine("2.5л");
        carDto.setDescription("Подробнее об условиях аренды...");
        carDto.setDescriptionPrice("от 1 до 2 суток 200 000тг.");
        carDto.setColor("Белый");

        CarDto savedCar = carService.create(carDto);

        assertNotNull(savedCar.getId(), "ID машины должен быть не null!");

        carService.delete(savedCar.getId());

        assertThrows(RuntimeException.class, () -> carService.getById(savedCar.getId()));
    }
}
