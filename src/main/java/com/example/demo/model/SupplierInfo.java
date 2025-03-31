package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;


@Getter
@Setter
@Entity
@Table(name = "supplier_info")
public class SupplierInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 自增ID

    @NotNull(message = "Supplier ID cannot be null")
    @Column(nullable = false)
    private Long supplierId;  // 供应商ID

    @NotNull(message = "Organization name cannot be null")
    @Size(max = 128, message = "Organization name must be less than 128 characters")
    @Column(nullable = false, length = 128)
    private String organizationName;  // 企业名称

    @NotNull(message = "Organization code cannot be null")
    @Size(max = 128, message = "Organization code must be less than 128 characters")
    @Column(nullable = false, length = 128)
    private String organizationCode;  // 统一社会信用代码

    @Min(value = 1, message = "Supplier nature must be a positive number")
    private Integer supplierNature;  // 供应商性质

    @Size(max = 500, message = "Note must be less than 500 characters")
    private String note;  // 备注

    @Lob
    private String qualification;  // 供应商资质（如果较复杂，可以考虑用 JSON）

    @NotNull(message = "Create time cannot be null")
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;  // 创建时间

    private String createOperator;  // 创建操作人

    @NotNull(message = "Last update time cannot be null")
    @Column(nullable = false)
    private LocalDateTime lastUpdateTime;  // 最后更新时间

    private String lastUpdateOperator;  // 更新操作人

    @NotNull(message = "Deleted status cannot be null")
    @Column(nullable = false)
    private Boolean isDeleted = false;  // 是否已删除
}
