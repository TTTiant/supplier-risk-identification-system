package com.example.demo.service;

import com.example.demo.model.SupplierInfo;
import com.example.demo.repository.SupplierInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.Optional;

@Service
public class SupplierInfoService {

    private final SupplierInfoRepository supplierInfoRepository;

    // 注入 SupplierInfoRepository
    @Autowired
    public SupplierInfoService(SupplierInfoRepository supplierInfoRepository) {
        this.supplierInfoRepository = supplierInfoRepository;
    }
    public Optional<SupplierInfo> getSupplierById(Long supplierId) {
        return supplierInfoRepository.findById(supplierId);
    }

    public Optional<SupplierInfo> getSupplierByIdAndIsDeletedFalse(Long supplierId) {
        return supplierInfoRepository.findBySupplierIdAndIsDeletedFalse(supplierId);
    }

    public SupplierInfo createSupplier(SupplierInfo supplierInfo) {
        LocalDateTime now = LocalDateTime.now();
        supplierInfo.setCreateTime(now);
        supplierInfo.setLastUpdateTime(now);
        supplierInfo.setIsDeleted(false);
        supplierInfo.setCreateOperator("system"); // 或者从登录用户中取
        supplierInfo.setLastUpdateOperator("system");
        return supplierInfoRepository.save(supplierInfo);
    }



}
