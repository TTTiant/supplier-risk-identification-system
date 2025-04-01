package com.example.demo.controller;

import com.example.demo.model.RiskLabel;
import com.example.demo.service.RiskLabelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk_label")
public class RiskLabelController {

    @Autowired
    private RiskLabelService riskLabelService;

    @PostMapping
    public RiskLabel createRiskLabel(@RequestBody RiskLabel riskLabel) {
        return riskLabelService.saveRiskLabel(riskLabel);
    }

    @GetMapping("/{id}")
    public RiskLabel getRiskLabel(@PathVariable int id) {
        return riskLabelService.getRiskLabelById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRiskLabel(@PathVariable int id) {
        riskLabelService.deleteRiskLabel(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskLabel> updateRiskLabel(@PathVariable Integer id, @RequestBody @Valid RiskLabel riskLabel) {
        RiskLabel updatedRiskLabel = riskLabelService.updateRiskLabel(id, riskLabel);
        if (updatedRiskLabel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 如果未找到，返回 404
        }
        return new ResponseEntity<>(updatedRiskLabel, HttpStatus.OK);
    }
}
