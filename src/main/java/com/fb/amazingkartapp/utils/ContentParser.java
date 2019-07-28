package com.fb.amazingkartapp.utils;

import java.util.List;

public interface ContentParser {
    Object parse(String content);

    List parseToList(Object productsInformation);

    Double parseExchangeRate(Object rateInformation, String currency);
}
