package com.boe.bidm.study.microservice.project2.university;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AA_UNIVERSITY")
@Data
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;

    @Column(name = "UNIVERSITY_CODE")
    String universityCode;

    @Column(name = "UNIVERSITY_NAME")
    String universityName;

    @Column(name = "CITY_CODE")
    String cityCode;

    @Column(name = "MODIFY_BY")
    String modifyBy;

    @Column(name = "MODIFY_TIME")
    LocalDateTime modifyTime;

    @Column(name = "CREATE_BY")
    String createBy;

    @Column(name = "CREATE_TIME")
    LocalDateTime createTime;
}
