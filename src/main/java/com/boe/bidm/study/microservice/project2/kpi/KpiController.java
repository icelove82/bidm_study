package com.boe.bidm.study.microservice.project2.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class KpiController {

    @Autowired
    KpiService mKpiService;

    @GetMapping("/kpi/01")
    public List<KpiChart01> getKpiChart01() {

        return mKpiService.getKpiChart01();
    }

    @GetMapping("/kpi/02")
    public List<KpiChart02> getKpiChart02() {

        return mKpiService.getKpiChart02();
    }
}
