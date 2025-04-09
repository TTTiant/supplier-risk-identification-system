package com.example.demo.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "risk_label")
public class RiskLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int riskLabelId;  // 风险标签ID

    @Column(nullable = false)
    private Long supplierId;  // 供应商ID

    @Column(nullable = false)
    private String riskLabelName;  // 风险标签名称

    @Column(nullable = false)
    private String riskLabelLevel;  // 风险标签等级

    @Column(nullable = false)
    private LocalDateTime lastUpdatedTime;  // 更新时间

    // Lombok 的 @Getter 和 @Setter 注解会自动生成 getter 和 setter 方法
}
