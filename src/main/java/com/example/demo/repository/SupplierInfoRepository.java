package com.example.demo.repository;

import com.example.demo.model.SupplierInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierInfoRepository extends JpaRepository<SupplierInfo, Long> {

    // 根据 supplierId 查询供应商信息
    Optional<SupplierInfo> findBySupplierId(Long supplierId);

    // 查询未删除的供应商（isDeleted = false）
    Optional<SupplierInfo> findBySupplierIdAndIsDeletedFalse(Long supplierId);

    Optional<SupplierInfo> findById(Long id);

}
