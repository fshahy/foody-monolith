package ir.fshahy.foody.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.fshahy.foody.model.City;
import ir.fshahy.foody.repository.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepo;
	
	public List<City> getAll() {
		return cityRepo.findAll();
	}
	
	public Optional<City> getCityById(Long id) {
		return cityRepo.findById(id);
	}
	
	public City addCity(City city) {
		if(cityRepo.existsCityByName(city.getName())) {
			return cityRepo.getCityByName(city.getName());
		}
		
		return cityRepo.save(city);
	}
}
