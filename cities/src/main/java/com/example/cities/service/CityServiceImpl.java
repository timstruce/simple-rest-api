package com.example.cities.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cities.exception.ResourceNotFound;
import com.example.cities.model.City;
import com.example.cities.repository.CityRepository;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository repository;
	
	@Override
	public List<City> getAllCities() {
		return this.repository.findAll();
	}

	@Override
	public City getCityById(long cityId) {
		Optional<City> cityDb = this.repository.findById(cityId);
		
		if(cityDb.isPresent()) {
			return cityDb.get();
		}
		else {
			throw new ResourceNotFound ("Record with id " + cityId + " not found!");
		}
	}

	@Override
	public City createCity(City city) {
		return this.repository.save(city);
	}

	@Override
	public City updateCity(City city) {
		Optional<City> cityDb = this.repository.findById(city.getId());
		
		if(cityDb.isPresent()) {
			City updateCity = cityDb.get();
			updateCity.setId(city.getId());
			updateCity.setName(city.getName());
			updateCity.setPopulation(city.getPopulation());
			updateCity.setZipCode(city.getZipCode());
			
			this.repository.save(updateCity);
			return updateCity;
		}
		else {
			throw new ResourceNotFound ("Record with id " + city.getId() + " not found!");
		}
	}

	@Override
	public void deleteCity(long cityId) {
		Optional<City> cityDb = this.repository.findById(cityId);
		
		if(cityDb.isPresent()) {
			this.repository.delete(cityDb.get());
		}
		else {
			throw new ResourceNotFound ("Record with id " + cityId + " not found!");
		}	
	}

}
