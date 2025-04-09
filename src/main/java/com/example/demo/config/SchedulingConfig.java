package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling  // 启用定时任务
public class SchedulingConfig {
    // 这个类为空，仅仅用于启用定时任务支持
}

