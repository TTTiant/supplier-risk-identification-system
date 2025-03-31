package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping
    public void setValue(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
    }

    @GetMapping
    public String getValue(@RequestParam(value = "key", required = false) String key) {
        if (key == null || key.isEmpty()) {
            return "Key is missing";
        }
        return redisService.getValue(key);
    }


}
