package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "risk_label_history")
public class RiskLabelHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 自增ID

    @Column(nullable = false)
    private Long supplierId;  // 供应商ID

    @Lob
    @Column(nullable = false)
    private String labelJson;  // 风险标签详情（JSON 格式）

    @Column(nullable = false)
    private LocalDateTime scanTime;  // 扫描时间

    // Getters and Setters
}
