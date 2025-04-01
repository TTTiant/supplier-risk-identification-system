package com.example.demo.controller;

import com.example.demo.service.RiskEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk")
public class RiskEngineController {

    private final RiskEngineService riskEngineService;

    @Autowired
    public RiskEngineController(RiskEngineService riskEngineService) {
        this.riskEngineService = riskEngineService;
    }

    @PostMapping("/process")
    public void processRisk(@RequestParam String companyId) {
        riskEngineService.processCompanyRisk(companyId);
    }
}
