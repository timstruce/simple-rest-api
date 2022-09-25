package com.example.cities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cities.model.City;
import com.example.cities.service.CityService;

@RestController
public class CityController {
	
	@Autowired 
	private CityService cityService;
	
	@GetMapping("/cities")
	public ResponseEntity<List<City>> getAllCities() {
		return ResponseEntity.ok().body(this.cityService.getAllCities());
	}
	
	@GetMapping("/cities/{id}")
	public ResponseEntity<City> getCityById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.cityService.getCityById(id));
	}
	
	@PostMapping("/cities")
	public ResponseEntity<City> createCity(@RequestBody City city) {
		return ResponseEntity.ok().body(this.cityService.createCity(city));
	}
	
	@PutMapping("/cities/{id}")
	public ResponseEntity<City> updateCity(@PathVariable long id, @RequestBody City city) {
		city.setId(id);
		return ResponseEntity.ok().body(this.cityService.updateCity(city));
	}
	
	@DeleteMapping("/cities/{id}")
	public HttpStatus deleteCity(@PathVariable long id) {
		this.cityService.deleteCity(id);
		return HttpStatus.OK;
	}
}
