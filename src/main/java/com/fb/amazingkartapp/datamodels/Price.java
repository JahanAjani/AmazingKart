package com.fb.amazingkartapp.datamodels;


public class Price {
    private Double value;
    private String currency;
    private Double priceInBaseCurrency;


    public Price(Double value, String ccy){
        this.value = value;
        this.currency = ccy;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency(){
        return this.currency;
    }

    public Double getPriceInBaseCurrency() {
        return priceInBaseCurrency;
    }

    public void setPriceInBaseCurrency(Double priceInBaseCurrency) {
        this.priceInBaseCurrency = priceInBaseCurrency;
    }


}
