package com.example.CarProject.api;

import com.example.CarProject.dto.CarCategoryDto;
import com.example.CarProject.service.CarCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarCategoryApi {

    private final CarCategoryService carCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CarCategoryDto>> getAll() {
        return ResponseEntity.ok(carCategoryService.getAll());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CarCategoryDto> getByIdCategory(@PathVariable Long id) {
        return ResponseEntity.ok(carCategoryService.getByIdCategory(id));
    }

    @PostMapping("/categories/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CarCategoryDto> createCategory(@RequestBody CarCategoryDto carCategoryDto) {
        return ResponseEntity.ok(carCategoryService.createCategory(carCategoryDto));
    }

    @PutMapping("/categories/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CarCategoryDto> updateCategory(@PathVariable Long id, @RequestBody CarCategoryDto carCategoryDto) {
        return ResponseEntity.ok(carCategoryService.updateCategory(id, carCategoryDto));
    }

    @DeleteMapping("/categories/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CarCategoryDto> delete(@PathVariable Long id) {
        carCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
