package com.example.CarProject.api;

import com.example.CarProject.dto.CarDto;
import com.example.CarProject.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarApi {

    private final CarService carService;

    @GetMapping("/cars/allCars")
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(carService.getAllCars());
    }
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getById(id));
    }
    @PostMapping("/cars/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CarDto> create(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.create(carDto));
    }

    @PutMapping("/cars/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CarDto> update(@PathVariable Long id, @RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.update(id, carDto));
    }
    @DeleteMapping("/cars/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
