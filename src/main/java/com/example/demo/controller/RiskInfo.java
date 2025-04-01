package com.example.demo.controller;  // 如果使用 dto 包，可以修改为 com.example.demo.dto

public class RiskInfo {

    private String supplierCreditCode;
    private String companyName;
    private String companyStatus;
    private String legalRepresentative;
    private String registrationDate;
    private String riskType;
    private String riskDetail;
    private String riskLevel;

    public RiskInfo(String supplierCreditCode, String companyName, String companyStatus, String legalRepresentative,
                    String registrationDate, String riskType, String riskDetail, String riskLevel) {
        this.supplierCreditCode = supplierCreditCode;
        this.companyName = companyName;
        this.companyStatus = companyStatus;
        this.legalRepresentative = legalRepresentative;
        this.registrationDate = registrationDate;
        this.riskType = riskType;
        this.riskDetail = riskDetail;
        this.riskLevel = riskLevel;
    }

    // Getters and setters
    public String getSupplierCreditCode() {
        return supplierCreditCode;
    }

    public void setSupplierCreditCode(String supplierCreditCode) {
        this.supplierCreditCode = supplierCreditCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiskDetail() {
        return riskDetail;
    }

    public void setRiskDetail(String riskDetail) {
        this.riskDetail = riskDetail;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
