package com.example.demo.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "risk_label")
public class RiskLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int riskLabelId;  // 风险标签ID

    @Column(nullable = false)
    private String riskLabelName;  // 风险标签名称

    @Column(nullable = false)
    private String riskLabelLevel;  // 风险标签等级

    // Getters and Setters
}
