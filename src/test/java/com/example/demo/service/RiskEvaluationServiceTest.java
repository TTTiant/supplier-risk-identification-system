package com.example.demo.service;

import com.example.demo.model.SupplierInfo;
import com.example.demo.repository.SupplierInfoRepository;
import com.example.demo.repository.RiskLabelRepository;
import com.example.demo.repository.RiskLabelHistoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // 使用 JUnit 5 的 Mockito 扩展
public class RiskEvaluationServiceTest {

    @Mock
    private SupplierInfoRepository supplierInfoRepository;  // 模拟仓库

    @Mock
    private RiskLabelRepository riskLabelRepository;  // 模拟仓库

    @Mock
    private RiskLabelHistoryRepository riskLabelHistoryRepository;  // 模拟仓库

    @Mock
    private RiskLabelEngine riskLabelEngine;  // 模拟规则引擎

    @InjectMocks  // 自动将 mock 的依赖注入到目标对象
    private RiskEvaluationService riskEvaluationService;  // 注入到要测试的服务类

    @Test
    public void testEvaluateRisk() {
        // 模拟供应商数据
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setSupplierId(1L);
        supplierInfo.setSupplierNature(2);  // 假设这是一个 PO 风险标签

        // 模拟从数据库获取供应商信息
        when(supplierInfoRepository.findById(1L)).thenReturn(java.util.Optional.of(supplierInfo));

        // 模拟规则引擎返回的标签
        when(riskLabelEngine.generateRiskLabel(supplierInfo)).thenReturn("PO");

        // 调用方法
        riskEvaluationService.evaluateRisk(1L);

        // 验证结果
        Mockito.verify(riskLabelRepository).save(Mockito.any());  // 验证标签保存操作
        Mockito.verify(riskLabelHistoryRepository).save(Mockito.any());  // 验证标签历史记录保存操作
    }

    @Test
    public void testGenerateRiskLabelWithNoMatchingRules() {
        // 创建供应商数据
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setSupplierId(2L);
        supplierInfo.setSupplierNature(1);  // 不符合 PO 或 P1 规则

        // 模拟规则引擎返回没有匹配的标签
        when(riskLabelEngine.generateRiskLabel(supplierInfo)).thenReturn("默认标签");

        // 验证结果
        assertEquals("默认标签", riskLabelEngine.generateRiskLabel(supplierInfo));
    }
}
