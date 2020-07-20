package com.boe.bidm.study.microservice.project2.student;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "AA_STUDENT")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "STUDENT_CODE")
    String studentCode;

    @Column(name = "STUDENT_NAME")
    String studentName;

    @Column(name = "UNIVERSITY_CODE")
    String universityCode;

    @Column(name = "GENDER")
    String gender;

    @Column(name = "AGE")
    int age;

    @Column(name = "SCORE")
    int score;

    @Column(name = "MODIFY_BY")
    String modifyBY;

    @Column(name = "MODIFY_TIME")
    LocalDateTime modifyTime;

    @Column(name = "CREATE_BY")
    String createBy;

    @Column(name = "CREATE_TIME")
    LocalDateTime createTime;
}
