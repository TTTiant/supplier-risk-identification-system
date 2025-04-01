package com.example.demo.repository;

import com.example.demo.model.RiskLabelHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RiskLabelHistoryRepository extends JpaRepository<RiskLabelHistory, Long> {
    // 根据供应商 ID 查询风险标签历史记录
    List<RiskLabelHistory> findBySupplierId(Long supplierId);

    // 根据扫描时间查询历史记录
    List<RiskLabelHistory> findByScanTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    // 根据供应商ID和扫描时间查询历史记录
    List<RiskLabelHistory> findBySupplierIdAndScanTimeBetween(Long supplierId, LocalDateTime startTime, LocalDateTime endTime);

    // 根据供应商 ID 删除历史记录
    void deleteBySupplierId(Long supplierId);
}
