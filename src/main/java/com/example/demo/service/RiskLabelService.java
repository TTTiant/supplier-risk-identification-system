package com.example.demo.service;

import com.example.demo.model.RiskLabel;
import com.example.demo.repository.RiskLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiskLabelService {

    @Autowired
    private RiskLabelRepository riskLabelRepository;

    // 创建或更新风险标签
    public RiskLabel saveRiskLabel(RiskLabel riskLabel) {
        return riskLabelRepository.save(riskLabel);
    }

    // 根据 ID 获取风险标签
    public RiskLabel getRiskLabelById(int riskLabelId) {
        return riskLabelRepository.findById(riskLabelId)
                .orElseThrow(() -> new RuntimeException("Risk Label not found"));
    }

    // 删除风险标签
    public void deleteRiskLabel(int riskLabelId) {
        riskLabelRepository.deleteById(riskLabelId);
    }

    public RiskLabel createRiskLabel(RiskLabel riskLabel) {
        return riskLabelRepository.save(riskLabel);
    }

    public RiskLabel updateRiskLabel(Integer id, RiskLabel riskLabel) {
        // 1. 查找现有记录
        Optional<RiskLabel> existingRiskLabelOpt = riskLabelRepository.findById(id);

        // 2. 如果记录不存在，返回 null 或者抛出异常
        if (!existingRiskLabelOpt.isPresent()) {
            return null;  // 你也可以选择抛出一个自定义异常，提示未找到
        }

        // 3. 获取现有记录并更新字段
        RiskLabel existingRiskLabel = existingRiskLabelOpt.get();
        existingRiskLabel.setRiskLabelName(riskLabel.getRiskLabelName());  // 更新名称
        existingRiskLabel.setRiskLabelLevel(riskLabel.getRiskLabelLevel());  // 更新等级

        // 4. 保存更新后的记录
        return riskLabelRepository.save(existingRiskLabel);
    }

}
