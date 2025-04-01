package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {
    @GetMapping("/api/mock/tianyancha/risk_info")
    public MockRiskInfoResponse getRiskInfo(@RequestParam String supplierCreditCode) {
        System.out.println("Received supplierCreditCode: " + supplierCreditCode);  // 打印请求的参数

        if ("91310000MA1K4XXXXG".equals(supplierCreditCode)) {
            return new MockRiskInfoResponse("success", new RiskInfo("91310000MA1K4XXXXG", "北京某某科技有限公司", "吊销", "张三", "2018-01-01", "经营异常", "吊销", "P0"));
        } else {
            return new MockRiskInfoResponse("error", null);
        }
    }

}
