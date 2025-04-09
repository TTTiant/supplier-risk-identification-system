package com.example.demo.controller;

public class RiskInfo {
    private String supplierCreditCode;
    private String companyName;
    private String status;
    private String legalPerson;
    private String establishmentDate;
    private String riskType;
    private String riskDescription;
    private String riskLevel;

    public RiskInfo(String supplierCreditCode, String companyName, String status,
                    String legalPerson, String establishmentDate, String riskType,
                    String riskDescription, String riskLevel) {
        this.supplierCreditCode = supplierCreditCode;
        this.companyName = companyName;
        this.status = status;
        this.legalPerson = legalPerson;
        this.establishmentDate = establishmentDate;
        this.riskType = riskType;
        this.riskDescription = riskDescription;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}

