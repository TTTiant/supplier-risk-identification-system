package com.example.demo.service;
import com.example.demo.model.SupplierInfo;  // 导入 SupplierInfo 类

public class P1RiskLabelRule implements RiskLabelRule {

    @Override
    public String evaluate(SupplierInfo supplierInfo) {
        // 判断 P1 标签的规则：如信用评分低，黑名单，经营异常
        if (supplierInfo.getSupplierNature() == 1 || supplierInfo.getQualification().contains("经营异常")) {
            return "P1"; // 高风险
        }
        return null; // 不符合 P1 的规则
    }
}
