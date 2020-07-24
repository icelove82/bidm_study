package com.boe.bidm.study.microservice.project2.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository mStudentRepository;

    public List<Student> getStudent(String studentCode, String studentName, String universityCode) {

        return mStudentRepository
                .findAllByStudentCodeContainingAndStudentNameContainingAndUniversityCodeContaining(studentCode, studentName, universityCode);
    }

    public void deleteStudent(List<Student> studentList) {

        mStudentRepository.deleteAll(studentList);
    }

    public int saveStudent(List<Student> studentList) {
        // Time
        LocalDateTime timeNow = LocalDateTime.now();
        studentList.forEach(it -> {
            it.modifyTime = timeNow;
            it.modifyBy = "ymh";
            it.createTime = timeNow;
            it.createBy = "ymh";
        });
        return mStudentRepository.saveAll(studentList).size();
    }


}
