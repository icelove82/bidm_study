package com.boe.bidm.study.microservice.project2.kpi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KpiChart03 {

    String universityCode;

    String universityName;

    double totalAvg;

    double maleAvg;

    double femaleAvg;
}
