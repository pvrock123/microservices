package com.microservices.currencyconverterservice.service;

import com.microservices.currencyconverterservice.feignclient.CurrencyExchangeProxy;
import com.microservices.currencyconverterservice.model.CurrencyConverter;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConverterService(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    public CurrencyConverter retrieveCurrencyValue(String from, String to, Integer quantity) {
        CurrencyConverter currencyConverter = currencyExchangeProxy.retrieveCurrencyValue(from, to);
        currencyConverter.setTotalCurrencyValue(currencyConverter.getConversion() * quantity);
        return currencyConverter;
    }
}
