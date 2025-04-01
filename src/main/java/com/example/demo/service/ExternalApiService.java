package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {
    private final RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCompanyInfo(String companyId) {
        String apiUrl = "https://api.tianyancha.com/services/v4/company/" + companyId;
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
