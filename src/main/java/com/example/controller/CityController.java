package com.example.controller;

import com.example.model.City;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private IService<City> cityIService;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = cityIService.findALl();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody City city) {
        cityIService.save(city);
        return new ResponseEntity<>("Them thanh cong", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityIService.save(city);
        return new ResponseEntity<>("Sua thanh cong", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cityIService.delete(id);
        return new ResponseEntity<>("Xoa thanh cong", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<City>> search(@RequestParam String name) {
        List<City> cities = cityIService.findByName(name);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<List<City>> searchRegion(@PathVariable Long id) {
        List<City> cities = cityIService.findByRegion(id);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
