package com.example.service;

import com.example.model.City;
import com.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements IService<City> {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> findALl() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> findByName(String name) {
        return cityRepository.findAllByNameContaining(name);
    }

    @Override
    public List<City> findByRegion(Long id) {
        return cityRepository.findAllByRegionId(id);
    }
}
