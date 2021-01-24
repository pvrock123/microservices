package com.microservices.currencyexchangeservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

    @Id
    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private Float conversion;
    private String environment;

    public CurrencyExchange() {

    }

    protected CurrencyExchange(Long id, String from, String to, Float conversion, String environment) {
        super();
        this.id = id;
        this.currencyFrom = from;
        this.currencyTo = to;
        this.conversion = conversion;
        this.environment = environment;
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

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

}
