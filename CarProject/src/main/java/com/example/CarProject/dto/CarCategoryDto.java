package com.example.CarProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCategoryDto {
    private Long id;
    private String name;
    private List<CarDto> cars;
}
