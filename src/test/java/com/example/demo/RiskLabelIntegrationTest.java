package com.example.demo;

import com.example.demo.model.RiskLabel;
import com.example.demo.repository.RiskLabelRepository;
import com.example.demo.service.RiskLabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RiskLabelIntegrationTest {

    @Autowired
    private RiskLabelRepository riskLabelRepository;

    @Autowired
    private RiskLabelService riskLabelService;

    @Test
    @Transactional
    public void testCreateAndFetchRiskLabel() {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        // 使用 service 层创建数据
        RiskLabel savedRiskLabel = riskLabelService.createRiskLabel(riskLabel);

        // 使用 repository 层查询数据
        RiskLabel fetchedRiskLabel = riskLabelRepository.findById(savedRiskLabel.getRiskLabelId()).orElse(null);

        assertNotNull(fetchedRiskLabel);
        assertEquals(savedRiskLabel.getRiskLabelId(), fetchedRiskLabel.getRiskLabelId());
        assertEquals("经营异常", fetchedRiskLabel.getRiskLabelName());
        assertEquals("P0", fetchedRiskLabel.getRiskLabelLevel());
    }
}
