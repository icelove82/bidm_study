package com.boe.bidm.study.microservice.project2.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UniversityService {

    @Autowired
    UniversityRepository mUniversityRepository;

    public List<University> getUniversity(String universityCode, String universityName, String cityCode) {

        return mUniversityRepository
                .findAllByUniversityCodeContainingAndUniversityNameContainingAndCityCodeContaining
                        (universityCode, universityName, cityCode);
    }

    public void deleteUniversity(List<University> universityList) {

        mUniversityRepository.deleteAll(universityList);
    }

    public int saveUniversity(List<University> universityList) {
        // Time
        LocalDateTime timeNow = LocalDateTime.now();
        universityList.forEach(it -> {
            it.modifyTime = timeNow;
            it.modifyBy = "ymh";
            it.createTime = timeNow;
            it.createBy = "ymh";
        });
        return mUniversityRepository.saveAll(universityList).size();
    }
}
