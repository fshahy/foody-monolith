package ir.fshahy.foody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.fshahy.foody.model.City;
import ir.fshahy.foody.service.CityService;

@RestController
@RequestMapping("${foody.api.base.path}/${foody.api.version}/city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<City>> getAll() {
		return ResponseEntity.ok().body(cityService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<City> getCityById(@PathVariable Long id) {
		return cityService.getCityById(id)
			.map(city -> {
				return ResponseEntity.ok().body(city);
			})
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<City> addCity(@RequestBody City city) {
		return ResponseEntity.ok().body(cityService.addCity(city));
	}
}
