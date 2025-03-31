package com.example.demo.controller;

import com.example.demo.model.SupplierInfo;
import com.example.demo.service.SupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/supplier")
public class SupplierInfoController {

    private final SupplierInfoService supplierInfoService;

    @Autowired
    public SupplierInfoController(SupplierInfoService supplierInfoService) {
        this.supplierInfoService = supplierInfoService;
    }

    // 根据 supplierId 获取供应商信息
    @GetMapping("/{supplierId}")
    public SupplierInfo getSupplierInfo(@PathVariable Long supplierId) {
        // 使用 orElseThrow 来处理供应商未找到的情况，抛出 404 错误
        return supplierInfoService.getSupplierById(supplierId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    // 根据 supplierId 获取未删除的供应商信息
    @GetMapping("/{supplierId}/active")
    public SupplierInfo getActiveSupplierInfo(@PathVariable Long supplierId) {
        // 使用 orElseThrow 来处理供应商未找到的情况，抛出 404 错误
        return supplierInfoService.getSupplierByIdAndIsDeletedFalse(supplierId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    // 处理供应商数据的 POST 请求
    @PostMapping
    public SupplierInfo createSupplier(@RequestBody @Valid SupplierInfo supplierInfo) {
        return supplierInfoService.createSupplier(supplierInfo);
    }
}
