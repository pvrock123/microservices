package com.microservices.currencyconverterservice.service;

import com.microservices.currencyconverterservice.model.CurrencyConverter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConverterService {

    private final Environment environment;

    public CurrencyConverterService(Environment environment) {
        this.environment = environment;
    }

    public CurrencyConverter retrieveCurrencyValue(String from, String to, Integer quantity) {
        CurrencyConverter currencyConverter = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/" + from + "/to/" + to, CurrencyConverter.class).getBody();
        currencyConverter.setTotalCurrencyValue(currencyConverter.getConversion() * quantity);
        currencyConverter.setEnvironment(environment.getProperty("local.server.port"));
        return currencyConverter;
    }
}
