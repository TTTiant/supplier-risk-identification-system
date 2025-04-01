package com.example.demo.repository;

import com.example.demo.model.RiskLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiskLabelRepository extends JpaRepository<RiskLabel, Integer> {

    // 根据标签名称查找风险标签
    Optional<RiskLabel> findByRiskLabelName(String riskLabelName);

    // 根据标签等级查找风险标签
    List<RiskLabel> findByRiskLabelLevel(String riskLabelLevel);

    // 判断标签是否存在
    boolean existsByRiskLabelName(String riskLabelName);

    // 根据标签名称和标签等级查询风险标签
    Optional<RiskLabel> findByRiskLabelNameAndRiskLabelLevel(String riskLabelName, String riskLabelLevel);

    // 删除指定标签的风险标签
    void deleteByRiskLabelName(String riskLabelName);
}
