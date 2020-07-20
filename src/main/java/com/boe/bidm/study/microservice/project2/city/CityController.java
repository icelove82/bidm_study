package com.boe.bidm.study.microservice.project2.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CityController {

    /**
     * Parameter name
     */
    public final static String ID = "ID";
    public final static String CODE = "CODE";
    public final static String NAME = "NAME";

    @Autowired
    CityService mCityService;

    @GetMapping("/city")
    public List<City> getCity(@RequestParam(CODE) String code, @RequestParam(NAME) String name) {

        return mCityService.getCity(code, name);
    }

    @DeleteMapping("/city")
    public void deleteCity(@RequestBody List<City> cityList) {

        mCityService.deleteCity(cityList);
    }

}
