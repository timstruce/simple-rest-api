package com.example.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cities.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
