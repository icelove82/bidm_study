package com.boe.bidm.study.microservice.legacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BoeController {

    /**
     * Parameter name
     */
    public final static String NAME = "NAME";
    public final static String GENDER = "GENDER";
    public final static String ID = "ID";

    @Autowired
    StudentServiceLegacy mStudentServiceLegacy;

    @GetMapping("/boe/all")
    public List<StudentLegacy> getAllStudent() {

        return mStudentServiceLegacy.getAllStudent();
    }

    @GetMapping("/boe/students")
    public List<StudentLegacy> getByNameAndGender(@RequestParam(NAME) String name, @RequestParam(GENDER) String gender) {

        return mStudentServiceLegacy.getByNameAndGender(name, gender);
    }

    @PostMapping("/boe/students")
    public int saveAllStudent(@RequestBody List<StudentLegacy> data) {

        return mStudentServiceLegacy.saveAllStudent(data);
    }

    @DeleteMapping("/boe/student")
    public void deleteAllStudent(@RequestParam(ID) int id) {

        mStudentServiceLegacy.deleteStudent(id);
    }
}
