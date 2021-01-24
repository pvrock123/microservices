package com.microservices.currencyconverterservice.controller;

import com.microservices.currencyconverterservice.model.CurrencyConverter;
import com.microservices.currencyconverterservice.service.CurrencyConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;


    public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverter retrieveCurrencyValue(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
        return currencyConverterService.retrieveCurrencyValue(from, to, quantity);
    }
}
