package com.boe.bidm.study.microservice.project2.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {

    /**
     * Parameter name
     */
    public final static String ID = "ID";
    public final static String CODE = "CODE";
    public final static String NAME = "NAME";
    public final static String UNIVERSITY_CODE = "UNIVERSITY_CODE";

    @Autowired
    StudentService mStudentService;

    @GetMapping("/student")
    public List<Student> getStudent(@RequestParam(CODE) String code, @RequestParam(NAME) String name, @RequestParam(UNIVERSITY_CODE) String universityCode) {

        return mStudentService.getStudent(code, name, universityCode);
    }

    @DeleteMapping("/student")
    public void deleteStudent(@RequestBody List<Student> studentList) {

        mStudentService.deleteStudent(studentList);
    }

    @PostMapping("/student")
    public int saveStudent(@RequestBody List<Student> studentList) {

        return mStudentService.saveStudent(studentList);
    }
}
