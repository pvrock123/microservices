package com.microservices.currencyconverterservice.controller;

import com.microservices.currencyconverterservice.model.CurrencyConverter;
import com.microservices.currencyconverterservice.service.CurrencyConverterService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConverterController {

    private final Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);
    private final CurrencyConverterService currencyConverterService;


    public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverter retrieveCurrencyValue(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
        return currencyConverterService.retrieveCurrencyValue(from, to, quantity);
    }

    @Retry(name = "sample-api", fallbackMethod = "backup")
    @GetMapping("test-api")
    public String testApi() {
        logger.info("Calling Rest Api");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http//:localhost:4567", String.class);
        return entity.getBody();
    }

    @CircuitBreaker(name = "default", fallbackMethod = "backup")
    @GetMapping("circuit-api")
    public String testCircuitApi() {
        logger.info("Calling Circuit Api");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http//:localhost:4567", String.class);
        return entity.getBody();
    }

    @RateLimiter(name = "default")
    @GetMapping("rate-api")
    public String testRateApi() {
        logger.info("Calling Circuit Api");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http//:localhost:4567", String.class);
        return entity.getBody();
    }

    @Bulkhead(name = "default")
    @GetMapping("bulk-api")
    public String testBulkApi() {
        logger.info("Calling Circuit Api");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http//:localhost:4567", String.class);
        return entity.getBody();
    }


    private String backup(Exception ex) {
        return "backup mathod call";
    }
}
