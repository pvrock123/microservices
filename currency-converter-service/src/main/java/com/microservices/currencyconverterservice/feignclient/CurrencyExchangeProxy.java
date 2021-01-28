package com.microservices.currencyconverterservice.feignclient;

import com.microservices.currencyconverterservice.model.CurrencyConverter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "currency-exchange", url = "localhost:8001")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    CurrencyConverter retrieveCurrencyValue(@PathVariable String from, @PathVariable String to);

}
