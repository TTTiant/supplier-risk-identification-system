package com.example.demo.service;

import com.example.demo.model.RiskLabel;
import com.example.demo.repository.RiskLabelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class RiskLabelServiceTests {

    @Mock
    private RiskLabelRepository riskLabelRepository;

    @InjectMocks
    private RiskLabelService riskLabelService;

    @Test
    public void testCreateRiskLabel() {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        // Mock the repository save method
        when(riskLabelRepository.save(riskLabel)).thenReturn(riskLabel);

        // Test the service method
        RiskLabel savedRiskLabel = riskLabelService.createRiskLabel(riskLabel);

        assertNotNull(savedRiskLabel);
        assertEquals("经营异常", savedRiskLabel.getRiskLabelName());
        assertEquals("P0", savedRiskLabel.getRiskLabelLevel());
    }
}
