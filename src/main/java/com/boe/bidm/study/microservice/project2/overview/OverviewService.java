package com.boe.bidm.study.microservice.project2.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverviewService {

    @Autowired
    OverviewRepository mOverviewRepository;

    public List<Overview> getOverview(
            String cityCode,
            String cityName,
            String universityCode,
            String universityName,
            String studentCode,
            String studentName) {

        return mOverviewRepository.findOverviewData(
                '%' + cityCode + '%',
                '%' + cityName + '%',
                '%' + universityCode + '%',
                '%' + universityName + '%',
                '%' + studentCode + '%',
                '%' + studentName + '%');
    }
}
