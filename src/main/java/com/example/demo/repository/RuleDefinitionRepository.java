package com.example.demo.repository;

import com.example.demo.model.RuleDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RuleDefinitionRepository extends JpaRepository<RuleDefinition, Long> {
    List<RuleDefinition> findByIsActiveTrue();  // 获取所有活跃的规则
}
