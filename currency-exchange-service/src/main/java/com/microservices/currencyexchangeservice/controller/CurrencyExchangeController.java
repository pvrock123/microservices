package com.microservices.currencyexchangeservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;
    private final Environment environment;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService, Environment environment) {
        this.currencyExchangeService = currencyExchangeService;
        this.environment = environment;
    }

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) throws RuntimeException, JsonProcessingException {
        CurrencyExchange exchange = currencyExchangeService.retrieveCurrencyExchange(from, to);
        if (exchange == null) {
            throw new RuntimeException("Enable to find data from " + from + " to " + to);
        }
        exchange.setEnvironment(environment.getProperty("local.server.port"));
        return exchange;
    }
}
