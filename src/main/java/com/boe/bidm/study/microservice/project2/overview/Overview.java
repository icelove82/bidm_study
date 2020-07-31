package com.boe.bidm.study.microservice.project2.overview;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAKE_OVERVIEW")
@Data
public class Overview {

    @Id
    @Column(name = "ID")
    int id;

    @Column(name = "CITY_CODE")
    String cityCode;

    @Column(name = "CITY_NAME")
    String cityName;

    @Column(name = "UNIVERSITY_CODE")
    String universityCode;

    @Column(name = "UNIVERSITY_NAME")
    String universityName;

    @Column(name = "STUDENT_CODE")
    String studentCode;

    @Column(name = "STUDENT_NAME")
    String studentName;

    @Column(name = "GENDER")
    String gender;

    @Column(name = "AGE")
    int age;

    @Column(name = "SCORE")
    int score;
}
