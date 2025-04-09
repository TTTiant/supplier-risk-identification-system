package com.example.demo.service;

import com.example.demo.model.SupplierInfo;

public class P0RiskLabelRule implements RiskLabelRule {

    @Override
    public String evaluate(SupplierInfo supplierInfo) {
        // 判断 PO 标签的规则：例如信用评分高，行业风险低
        if (supplierInfo.getSupplierNature() == 2 && supplierInfo.getQualification().contains("财务健康")) {
            return "P0"; // 低风险
        }
        return null; // 不符合 P0 的规则
    }
}
