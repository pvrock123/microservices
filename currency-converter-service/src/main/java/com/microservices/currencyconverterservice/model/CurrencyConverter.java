package com.microservices.currencyconverterservice.model;

public class CurrencyConverter {

    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private Float conversion;
    private Float totalCurrencyValue;
    private String environment;

    public CurrencyConverter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public Float getConversion() {
        return conversion;
    }

    public void setConversion(Float conversion) {
        this.conversion = conversion;
    }

    public Float getTotalCurrencyValue() {
        return totalCurrencyValue;
    }

    public void setTotalCurrencyValue(Float totalCurrencyValue) {
        this.totalCurrencyValue = totalCurrencyValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
