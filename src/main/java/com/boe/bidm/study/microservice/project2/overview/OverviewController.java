package com.boe.bidm.study.microservice.project2.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OverviewController {

    /**
     * Parameter name
     */
    public final static String CITY_CODE = "CITY_CODE";
    public final static String CITY_NAME = "CITY_NAME";
    public final static String UNIVERSITY_CODE = "UNIVERSITY_CODE";
    public final static String UNIVERSITY_NAME = "UNIVERSITY_NAME";
    public final static String STUDENT_CODE = "STUDENT_CODE";
    public final static String STUDENT_NAME = "STUDENT_NAME";

    @Autowired
    OverviewService mOverviewService;

    @GetMapping("/overview")
    public List<Overview> getCity(
            @RequestParam(CITY_CODE) String cityCode, @RequestParam(CITY_NAME) String cityName,
            @RequestParam(UNIVERSITY_CODE) String universityCode, @RequestParam(UNIVERSITY_NAME) String universityName,
            @RequestParam(STUDENT_CODE) String studentCode, @RequestParam(STUDENT_NAME) String studentName) {

        return mOverviewService.getOverview(cityCode, cityName, universityCode, universityName, studentCode, studentName);
    }
}
