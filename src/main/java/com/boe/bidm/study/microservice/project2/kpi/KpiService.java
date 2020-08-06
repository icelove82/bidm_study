package com.boe.bidm.study.microservice.project2.kpi;

import com.boe.bidm.study.microservice.project2.city.City;
import com.boe.bidm.study.microservice.project2.city.CityRepository;
import com.boe.bidm.study.microservice.project2.student.Student;
import com.boe.bidm.study.microservice.project2.student.StudentRepository;
import com.boe.bidm.study.microservice.project2.university.University;
import com.boe.bidm.study.microservice.project2.university.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KpiService {

    @Autowired
    CityRepository mCityRepository;

    @Autowired
    UniversityRepository mUniversityRepository;

    @Autowired
    StudentRepository mStudentRepository;

    // 每个城市大学数量
    public List<KpiChart01> getKpiChart01() {

        List<City> cityList = mCityRepository.findAll();
        List<University> universityList = mUniversityRepository.findAll();

        List<KpiChart01> resultList = new ArrayList<>();

        cityList.forEach(
                city -> {
                    long count = universityList.parallelStream()
                            .filter(university -> university.getCityCode().equals(city.getCityCode()))
                            .count();

                    resultList.add(KpiChart01.builder()
                            .cityCode(city.getCityCode())
                            .cityName(city.getCityName())
                            .count(count)
                            .build());

                }
        );

        return resultList;
    }

    // 每个城市学生总数，男生总数，女生总数
    public List<KpiChart02> getKpiChart02() {

        List<KpiChart02> resultList = new ArrayList<>();

        List<City> cityList = mCityRepository.findAll();
        List<University> universityList = mUniversityRepository.findAll();
        List<Student> studentList = mStudentRepository.findAll();

        cityList.forEach(
                city -> {
                    List<University> filterUniversity = universityList.parallelStream()
                            .filter(university -> university.getCityCode().equals(city.getCityCode()))
                            .collect(Collectors.toList());

                    List<Student> filterStudent = studentList.parallelStream()
                            .filter(student ->
                                    filterUniversity.stream()
                                            .map(University::getUniversityCode)
                                            .anyMatch(it -> it.equals(student.getUniversityCode())))
                            .collect(Collectors.toList());


                    long totalCount = filterStudent.size();

                    long maleCount = filterStudent.parallelStream()
                            .filter(student -> student.getGender().equals("M"))
                            .count();

                    long femaleCount = filterStudent.parallelStream()
                            .filter(student -> student.getGender().equals("F"))
                            .count();

                    resultList.add(KpiChart02.builder()
                            .cityCode(city.getCityCode())
                            .cityName(city.getCityName())
                            .totalCount(totalCount)
                            .maleCount(maleCount)
                            .femaleCount(femaleCount)
                            .build());
                }
        );
        return resultList;

    }
}
