package com.boe.bidm.study.microservice.project2.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository mStudentRepository;

    public List<Student> getStudent(String studentCode, String studentName, String universityCode) {

        return mStudentRepository
                .findAllByStudentCodeContainingAndStudentNameContainingAndUniversityCodeContaining(studentCode, studentName, universityCode);
    }
}
