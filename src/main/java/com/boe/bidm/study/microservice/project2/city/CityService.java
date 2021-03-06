package com.boe.bidm.study.microservice.project2.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CityService {

    @Autowired
    CityRepository mCityRepository;

    public List<City> getCity(String cityCode, String cityName) {

        return mCityRepository
                .findAllByCityCodeContainingAndCityNameContainingOrderByCityName(cityCode, cityName);
    }

    public void deleteCity(List<City> cityList) {
        mCityRepository.deleteAll(cityList);
    }

    public int saveCity(List<City> cityList) {
        // Time
        LocalDateTime timeNow = LocalDateTime.now();
        cityList.forEach(it -> {
            it.modifyTime = timeNow;
            it.modifyBy = "ymh";
            it.createTime = timeNow;
            it.createBy = "ymh";
        });
        return mCityRepository.saveAll(cityList).size();
    }

}
