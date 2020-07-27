package com.boe.bidm.study.microservice.project2.university;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    List<University> findAllByUniversityCodeContainingAndUniversityNameContainingAndCityCodeContaining(String code, String name, String cityCode);
}
