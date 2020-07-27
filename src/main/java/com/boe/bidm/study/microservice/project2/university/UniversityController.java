package com.boe.bidm.study.microservice.project2.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UniversityController {
    /**
     * Parameter name
     */
    public final static String ID = "ID";
    public final static String CODE = "CODE";
    public final static String NAME = "NAME";
    public final static String CITY_CODE = "CITY_CODE";

    @Autowired
    UniversityService mUniversityService;

    @GetMapping("/university")
    public List<University> getUniversity(@RequestParam(CODE) String code, @RequestParam(NAME) String name, @RequestParam(CITY_CODE) String cityCode) {

        return mUniversityService.getUniversity(code, name, cityCode);
    }

    @DeleteMapping("/university")
    public void deleteUniversity(@RequestBody List<University> universityList) {

        mUniversityService.deleteUniversity(universityList);
    }

    @PostMapping("/university")
    public int saveUniversity(@RequestBody List<University> universityList) {

        return mUniversityService.saveUniversity(universityList);
    }
}
