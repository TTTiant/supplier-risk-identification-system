package com.example.demo.service;

import com.example.demo.model.RiskLabelHistory;
import com.example.demo.repository.RiskLabelHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskLabelHistoryService {

    @Autowired
    private RiskLabelHistoryRepository riskLabelHistoryRepository;

    // 创建风险标签历史记录
    public RiskLabelHistory saveRiskLabelHistory(RiskLabelHistory riskLabelHistory) {
        return riskLabelHistoryRepository.save(riskLabelHistory);
    }

    // 根据 ID 获取风险标签历史
    public RiskLabelHistory getRiskLabelHistoryById(Long id) {
        return riskLabelHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk Label History not found"));
    }

    // 删除风险标签历史记录
    public void deleteRiskLabelHistory(Long id) {
        riskLabelHistoryRepository.deleteById(id);
    }
}
