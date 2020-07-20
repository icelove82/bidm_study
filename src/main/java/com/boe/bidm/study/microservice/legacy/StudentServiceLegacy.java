package com.boe.bidm.study.microservice.legacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceLegacy {

    @Autowired
    StudentRepositoryLegacy mStudentRepositoryLegacy;

    /**
     * Query all student data
     */
    public List<StudentLegacy> getAllStudent() {

        int auldtAge = 18;

        List<StudentLegacy> data = mStudentRepositoryLegacy.findAll();

        data.forEach(it -> {

            // 判断是否是成年人
            it.setAdult(it.getAge() > 18);
        });

        return data;

    }

    /**
     * Query student data by name and gender
     *
     * @param name
     * @param gender
     * @return
     */
    public List<StudentLegacy> getByNameAndGender(String name, String gender) {

        List<StudentLegacy> data = mStudentRepositoryLegacy.findAllByNameContainingAndGenderContaining(name, gender);

        data.forEach(it -> {

            // 判断是否是成年人
            it.setAdult(it.getAge() > 18);
        });

        return data;
    }

    /**
     * Insert or Update all student data
     */
    public int saveAllStudent(List<StudentLegacy> data) {

        return mStudentRepositoryLegacy.saveAll(data).size();
    }

    /**
     * Delete the student data
     */
    public void deleteStudent(int id) {

        mStudentRepositoryLegacy.deleteById(id);
    }
}
