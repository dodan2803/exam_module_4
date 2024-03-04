package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Region region;
    private double acreage;
    private int population;
    private double gdp;
    private String describe;
}
