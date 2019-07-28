package com.fb.amazingkartapp.services;

import com.fb.amazingkartapp.utils.ContentParser;
import com.fb.amazingkartapp.contants.AmazingKartConstants;

import java.io.IOException;

public class CurrencyConversionServiceImpl implements CurrencyConversionService{

    private ContentParser contentParser;

    public CurrencyConversionServiceImpl(ContentParser contentParser) {
        this.contentParser = contentParser;
    }

    public Double getRate(String currency) {

        Double rate = 1D;
        try {
            if(!AmazingKartConstants.SYSTEM_BASE_CURRENCY.equalsIgnoreCase(currency)) {
                rate = RestService.getRateFromExchange(currency, contentParser);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //throw service related exception.
        }

        return rate;
    }
}
