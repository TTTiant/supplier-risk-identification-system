package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rule_definitions")
public class RuleDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;  // 规则名称

    @Column(nullable = false)
    private String ruleType;  // 规则类型

    @Column(nullable = false)
    private String ruleCondition;  // 规则条件

    @Column(nullable = false)
    private boolean isActive;  // 是否启用规则

    // Getters and Setters
}
