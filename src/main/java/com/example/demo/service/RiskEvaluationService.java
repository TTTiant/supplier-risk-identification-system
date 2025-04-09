package com.example.demo.service;

import com.example.demo.model.SupplierInfo;
import com.example.demo.model.RiskLabel;
import com.example.demo.model.RiskLabelHistory;
import com.example.demo.repository.SupplierInfoRepository;
import com.example.demo.repository.RiskLabelRepository;
import com.example.demo.repository.RiskLabelHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;
//风险评估 和 标签生成 的服务类，利用 规则引擎 来为每个供应商生成风险标签，
// 并将这些标签信息保存到数据库中。它还使用了 Spring 的依赖注入 和 定时任务，来管理和更新风险标签

@Service
public class RiskEvaluationService {

    @Autowired
    private SupplierInfoRepository supplierInfoRepository; //用于从数据库中获取供应商信息

    @Autowired
    private RiskLabelRepository riskLabelRepository; //用于将生成的风险标签保存到数据库中

    @Autowired
    private RiskLabelHistoryRepository riskLabelHistoryRepository; //用于将标签历史记录保存到数据库中

    @Autowired
    private RiskLabelEngine riskLabelEngine;  // 规则引擎，用于根据供应商信息生成风险标签

    public void evaluateRisk(Long supplierId) {
        // 获取 SupplierInfo 对象，确保它是 Optional 中的值
        SupplierInfo supplierInfo = supplierInfoRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("供应商未找到"));

        // 使用依赖注入的 RiskLabelEngine 来生成风险标签
        String riskLabel = riskLabelEngine.generateRiskLabel(supplierInfo); // 正确传入 SupplierInfo 对象

        // 生成风险标签并保存
        RiskLabel label = new RiskLabel();
        label.setSupplierId(supplierId);
        label.setRiskLabelName(riskLabel);
        label.setRiskLabelLevel("高风险"); // 根据规则决定标签等级
        label.setLastUpdatedTime(LocalDateTime.now());
        riskLabelRepository.save(label);

        // 保存历史标签记录
        RiskLabelHistory riskLabelHistory = new RiskLabelHistory();
        riskLabelHistory.setSupplierId(supplierId);
        riskLabelHistory.setLabelJson(riskLabel);
        riskLabelHistory.setScanTime(LocalDateTime.now());
        riskLabelHistoryRepository.save(riskLabelHistory);
    }

    @Scheduled(cron = "0 0 0 * * ?")  // 每天午夜执行
    public void updateRiskLabelsForAllSuppliers() {
        List<SupplierInfo> suppliers = supplierInfoRepository.findAll();
        for (SupplierInfo supplier : suppliers) {
            evaluateRisk(supplier.getSupplierId());  // 为每个供应商执行风险评估
        }
    }
}
















