package com.example.demo.controller;

import com.example.demo.model.RiskLabel;
import com.example.demo.service.RiskLabelService;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RiskLabelController.class)
public class RiskLabelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock  // 或改用 @Mock + @InjectMocks（见下方注释）
    private RiskLabelService riskLabelService;

    @Test
    public void testCreateRiskLabel() throws Exception {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        when(riskLabelService.saveRiskLabel(any(RiskLabel.class))).thenReturn(riskLabel);

        mockMvc.perform(post("/api/risk_label")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"riskLabelName\":\"经营异常\",\"riskLabelLevel\":\"P0\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.riskLabelName").value("经营异常"))
                .andExpect(jsonPath("$.riskLabelLevel").value("P0"));
    }
}