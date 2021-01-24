package com.microservices.limitsservice.controller;

import com.microservices.limitsservice.config.LimitsConfiguration;
import com.microservices.limitsservice.model.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final LimitsConfiguration limitsConfiguration;

    public LimitsController(LimitsConfiguration limitsConfiguration) {
        this.limitsConfiguration = limitsConfiguration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(limitsConfiguration.getMin(), limitsConfiguration.getMax());
    }
}
