package com.example.CarProject.api;

import com.example.CarProject.dto.HomePageDto;
import com.example.CarProject.service.HomePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomePageApi {

    private final HomePageService homePageService;

    @GetMapping("/home")
    public ResponseEntity<List<HomePageDto>> getAllHomePages() {
        return ResponseEntity.ok(homePageService.getAllHomePages());
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<HomePageDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(homePageService.getById(id));
    }

    @PostMapping("/home/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HomePageDto> create(@RequestBody HomePageDto homePageDto) {
        return ResponseEntity.ok(homePageService.create(homePageDto));
    }

    @PutMapping("/home/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HomePageDto> update(@PathVariable Long id, @RequestBody HomePageDto homePageDto) {
        return ResponseEntity.ok(homePageService.update(id, homePageDto));
    }

    @DeleteMapping("/home/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HomePageDto> delete(@PathVariable Long id) {
        homePageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
