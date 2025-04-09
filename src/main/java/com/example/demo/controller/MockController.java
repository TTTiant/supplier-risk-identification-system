package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    // 模拟天眼查风险信息接口
    @GetMapping("/api/mock/tianyancha/risk_info")
    public MockRiskInfoResponse getRiskInfo(@RequestParam String supplierCreditCode) {
        System.out.println("Received supplierCreditCode: " + supplierCreditCode);  // 打印请求的参数

        // 模拟根据 supplierCreditCode 返回不同的风险信息
        if ("91310000MA1K4XXXXG".equals(supplierCreditCode)) {
            // 模拟返回某公司相关的风险信息
            return new MockRiskInfoResponse("success", new RiskInfo(
                    "91310000MA1K4XXXXG",        // 统一社会信用代码
                    "北京某某科技有限公司",     // 公司名称
                    "吊销",                     // 状态（如：吊销）
                    "张三",                     // 法人
                    "2018-01-01",               // 成立日期
                    "经营异常",                 // 风险类型
                    "吊销",                     // 风险描述（如：吊销）
                    "P0"                        // 风险等级
            ));
        } else if ("91310000MA1K4XXXXH".equals(supplierCreditCode)) {
            // 模拟返回另一个公司的风险信息
            return new MockRiskInfoResponse("success", new RiskInfo(
                    "91310000MA1K4XXXXH",        // 统一社会信用代码
                    "上海某某电子有限公司",     // 公司名称
                    "存续",                     // 状态（如：存续）
                    "李四",                     // 法人
                    "2015-05-20",               // 成立日期
                    "无风险",                   // 风险类型
                    "正常",                     // 风险描述（如：正常）
                    "P2"                        // 风险等级
            ));
        } else {
            // 当提供的 supplierCreditCode 不匹配时，返回错误响应
            return new MockRiskInfoResponse("error", null);
        }
    }
}
