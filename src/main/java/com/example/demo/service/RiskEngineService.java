package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskEngineService {
    private final ExternalApiService externalApiService;

    @Autowired
    public RiskEngineService(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    public void processCompanyRisk(String companyId) {
        String companyInfo = externalApiService.getCompanyInfo(companyId);

        // 模拟风控引擎处理
        if (companyInfo.contains("high risk")) {
            System.out.println("Risk Level: High");
        } else {
            System.out.println("Risk Level: Low");
        }
    }
}
