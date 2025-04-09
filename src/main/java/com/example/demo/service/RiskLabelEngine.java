package com.example.demo.service;

import com.example.demo.model.RuleDefinition;
import com.example.demo.model.SupplierInfo;
import com.example.demo.repository.RuleDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskLabelEngine {

    @Autowired
    private RuleDefinitionRepository ruleDefinitionRepository;

    private List<RiskLabelRule> riskLabelRules;

    public RiskLabelEngine() {
        riskLabelRules = new ArrayList<>();
        loadRules();  // 加载规则
    }

    // 动态加载规则
    public void loadRules() {
        // 从数据库加载所有活跃的规则
        List<RuleDefinition> rules = ruleDefinitionRepository.findByIsActiveTrue();

        // 根据规则的定义动态加载规则
        for (RuleDefinition rule : rules) {
            if (rule.getRuleName().equals("PO")) {
                riskLabelRules.add(new P0RiskLabelRule());  // 加载 PO 风险规则
            }
            if (rule.getRuleName().equals("P1")) {
                riskLabelRules.add(new P1RiskLabelRule());  // 加载 P1 风险规则
            }
            // 可以根据 rule_condition 添加更复杂的规则
        }
    }

    // 根据规则生成标签
    public String generateRiskLabel(SupplierInfo supplierInfo) {
        for (RiskLabelRule rule : riskLabelRules) {
            String label = rule.evaluate(supplierInfo);  // 传递 SupplierInfo 对象给规则
            if (label != null) {
                return label;  // 返回生成的标签
            }
        }
        return "默认标签";  // 如果没有规则匹配，返回默认标签
    }

    @Scheduled(fixedRate = 3600000)  // 每小时刷新一次规则
    public void refreshRules() {
        loadRules();  // 重新加载规则
    }

}
