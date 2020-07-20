package com.boe.bidm.study.microservice.project2.city;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "AA_CITY")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "CITY_CODE")
    String cityCode;

    @Column(name = "CITY_NAME")
    String cityName;

    @Column(name = "MODIFY_BY")
    String modifyBy;

    @Column(name = "MODIFY_TIME")
    LocalDateTime modifyTime;

    @Column(name = "CREATE_BY")
    String createBy;

    @Column(name = "CREATE_TIME")
    LocalDateTime createTime;

}
