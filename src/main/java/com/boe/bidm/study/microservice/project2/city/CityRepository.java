package com.boe.bidm.study.microservice.project2.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByCityCodeContainingAndCityNameContainingOrderByCityName(String cityCode, String cityName);
}
