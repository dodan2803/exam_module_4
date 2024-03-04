package com.example.service;

import java.util.List;
import java.util.Optional;

public interface IService<E> {
    void save(E e);
    void delete(Long id);
    List<E> findALl();
    Optional<E> findById(Long id);
    List<E> findByName(String name);
    List<E> findByRegion(Long id);
}
