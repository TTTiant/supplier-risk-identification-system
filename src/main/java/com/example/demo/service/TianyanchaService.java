package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TianyanchaService {

    // 从 application.properties 获取 API 密钥和基地址
    @Value("${tianyancha.api.key}")
    private String apiKey;

    @Value("${tianyancha.base.url}")
    private String baseUrl;

    // 使用 RestTemplate 来发起 HTTP 请求
    @Autowired
    private RestTemplate restTemplate;

    // 获取公司信息的方法
    public String getCompanyInfo(String companyName) {
        // 构建天眼查 API 请求的 URL
        String url = String.format("%s/ic/baseinfo/2.0?keyword=%s&api_key=%s", baseUrl, companyName, apiKey);

        // 发送 GET 请求并返回响应的 JSON 字符串
        return restTemplate.getForObject(url, String.class);
    }
}
