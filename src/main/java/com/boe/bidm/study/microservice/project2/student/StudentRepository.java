package com.boe.bidm.study.microservice.project2.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByStudentCodeContainingAndStudentNameContainingAndUniversityCodeContaining(String code, String name, String universityCode);
}
