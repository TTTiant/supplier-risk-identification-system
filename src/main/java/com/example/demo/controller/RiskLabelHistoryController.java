package com.example.demo.controller;

import com.example.demo.model.RiskLabelHistory;
import com.example.demo.service.RiskLabelHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk_label_history")
public class RiskLabelHistoryController {

    @Autowired
    private RiskLabelHistoryService riskLabelHistoryService;

    @PostMapping
    public RiskLabelHistory createRiskLabelHistory(@RequestBody RiskLabelHistory riskLabelHistory) {
        return riskLabelHistoryService.saveRiskLabelHistory(riskLabelHistory);
    }

    @GetMapping("/{id}")
    public RiskLabelHistory getRiskLabelHistory(@PathVariable Long id) {
        return riskLabelHistoryService.getRiskLabelHistoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRiskLabelHistory(@PathVariable Long id) {
        riskLabelHistoryService.deleteRiskLabelHistory(id);
    }
}
