package com.boe.bidm.study.microservice.legacy;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "ZIONEX_STUDENT")
@Data
public class StudentLegacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "NAME")
    String name;

    @Column(name = "GENDER")
    String gender;

    @Column(name = "AGE")
    int age;

    @Transient
    boolean isAdult;
}
