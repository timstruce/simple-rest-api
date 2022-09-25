package com.example.cities.service;

import java.util.List;

import com.example.cities.model.City;

public interface CityService {
	
	public List<City> getAllCities ();
	
	public City getCityById(long cityId);
	
	public City createCity (City city);
	
	public City updateCity (City city);

	public void deleteCity (long cityId);
}
