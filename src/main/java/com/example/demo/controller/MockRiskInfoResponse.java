package com.example.demo.controller;

public class MockRiskInfoResponse {

    private String status;
    private RiskInfo data;

    // Getters and setters
    public MockRiskInfoResponse(String status, RiskInfo data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RiskInfo getData() {
        return data;
    }

    public void setData(RiskInfo data) {
        this.data = data;
    }
}


