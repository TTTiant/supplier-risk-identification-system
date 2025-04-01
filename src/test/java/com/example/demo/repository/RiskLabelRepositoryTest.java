package com.example.demo.repository;

import com.example.demo.model.RiskLabel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RiskLabelRepositoryTest {

    @Autowired
    private RiskLabelRepository riskLabelRepository;

    @Test
    public void testSaveRiskLabel() {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        // 保存并验证是否插入成功
        RiskLabel savedRiskLabel = riskLabelRepository.save(riskLabel);
        assertNotNull(savedRiskLabel.getRiskLabelId());  // 验证 ID 是否生成
        assertEquals("经营异常", savedRiskLabel.getRiskLabelName());
        assertEquals("P0", savedRiskLabel.getRiskLabelLevel());
    }

    @Test
    public void testFindRiskLabelById() {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        RiskLabel savedRiskLabel = riskLabelRepository.save(riskLabel);

        // 查询并验证
        RiskLabel foundRiskLabel = riskLabelRepository.findById(savedRiskLabel.getRiskLabelId()).orElse(null);
        assertNotNull(foundRiskLabel);
        assertEquals(savedRiskLabel.getRiskLabelId(), foundRiskLabel.getRiskLabelId());
    }

    @Test
    public void testUpdateRiskLabel() {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        RiskLabel savedRiskLabel = riskLabelRepository.save(riskLabel);

        // 更新操作
        savedRiskLabel.setRiskLabelLevel("P1");
        RiskLabel updatedRiskLabel = riskLabelRepository.save(savedRiskLabel);

        // 验证更新
        assertEquals("P1", updatedRiskLabel.getRiskLabelLevel());
    }

    @Test
    public void testDeleteRiskLabel() {
        RiskLabel riskLabel = new RiskLabel();
        riskLabel.setRiskLabelName("经营异常");
        riskLabel.setRiskLabelLevel("P0");

        RiskLabel savedRiskLabel = riskLabelRepository.save(riskLabel);

        // 删除操作
        riskLabelRepository.delete(savedRiskLabel);
        RiskLabel deletedRiskLabel = riskLabelRepository.findById(savedRiskLabel.getRiskLabelId()).orElse(null);

        // 验证删除
        assertNull(deletedRiskLabel);
    }
}
