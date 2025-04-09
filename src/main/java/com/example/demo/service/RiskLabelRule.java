package com.example.demo.service;
import com.example.demo.model.SupplierInfo;  // 导入 SupplierInfo 类

public interface RiskLabelRule {
    String evaluate(SupplierInfo supplierInfo);  // 评估供应商数据，返回生成的标签
}
