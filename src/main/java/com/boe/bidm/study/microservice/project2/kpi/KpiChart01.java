package com.boe.bidm.study.microservice.project2.kpi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KpiChart01 {

    String cityCode;

    String cityName;

    long count;
}
