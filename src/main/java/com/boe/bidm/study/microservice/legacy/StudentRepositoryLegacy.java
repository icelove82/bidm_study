package com.boe.bidm.study.microservice.legacy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


/**
 * StudentRepository
 */
public interface StudentRepositoryLegacy extends JpaRepository<StudentLegacy, Integer> {


    List<StudentLegacy> findAllByNameContainingAndGenderContaining(String name, String gender);
}
