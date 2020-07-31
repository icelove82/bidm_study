package com.boe.bidm.study.microservice.project2.overview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OverviewRepository extends JpaRepository<Overview, Integer> {

    String joinQuery = "select C.ID, A.CITY_CODE, A.CITY_NAME,\n" +
            "       B.UNIVERSITY_CODE, B.UNIVERSITY_NAME,\n" +
            "       C.STUDENT_CODE, C.STUDENT_NAME, C.GENDER, C.AGE, C.SCORE\n" +
            "from AA_CITY as A, AA_UNIVERSITY as B, AA_STUDENT as C\n" +
            "where A.CITY_CODE = B.CITY_CODE and B.UNIVERSITY_CODE = C.UNIVERSITY_CODE\n" +
            "and A.CITY_CODE like :cityCode\n" +
            "and A.CITY_NAME like :cityName\n" +
            "and B.UNIVERSITY_CODE like :universityCode\n" +
            "and B.UNIVERSITY_NAME like :universityName\n" +
            "and C.STUDENT_CODE like :studentCode\n" +
            "and C.STUDENT_NAME like :studentName";


    @Query(value = joinQuery, nativeQuery = true)
    List<Overview> findOverviewData(
            @Param("cityCode") String cityCode,
            @Param("cityName") String cityName,
            @Param("universityCode") String universityCode,
            @Param("universityName") String universityName,
            @Param("studentCode") String studentCode,
            @Param("studentName") String studentName);
}
