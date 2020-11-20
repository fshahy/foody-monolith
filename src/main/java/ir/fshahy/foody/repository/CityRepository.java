package ir.fshahy.foody.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.fshahy.foody.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	boolean existsCityByName(String cityName);
	City getCityByName(String cityName);
}
