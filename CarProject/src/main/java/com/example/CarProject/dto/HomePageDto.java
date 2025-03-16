package com.example.CarProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomePageDto {

    private Long id;
    private String description;
    private String numbers;
    private String email;
    private String address;
    private String categoriesLink;
}
