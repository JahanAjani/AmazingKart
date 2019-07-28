package com.fb.amazingkartapp;

import com.fb.amazingkartapp.datamodels.Product;
import com.fb.amazingkartapp.exceptions.PromotionException;
import com.fb.amazingkartapp.promotion.Promotion;
import com.fb.amazingkartapp.services.CurrencyConversionService;
import com.fb.amazingkartapp.services.CurrencyConversionServiceImpl;
import com.fb.amazingkartapp.services.RestService;
import com.fb.amazingkartapp.utils.ContentParser;
import com.fb.amazingkartapp.utils.JsonContentParser;
import com.fb.amazingkartapp.utils.JsonTransformer;
import com.fb.amazingkartapp.utils.Transformer;
import com.fb.amazingkartapp.writers.DataWriter;
import com.fb.amazingkartapp.writers.FileDataWriter;

import java.util.List;

public class AmazingKart {

    private Promotion promotionSet;

    public AmazingKart(Promotion promotionSet){
        this.promotionSet = promotionSet;
    }

    public void execute() throws PromotionException {

        ContentParser contentParser = new JsonContentParser();
        Object productsInformation = RestService.getProductsInformation(contentParser);
        List<Product> products = contentParser.parseToList(productsInformation);

        applyCurrencyConversion(products, contentParser);

        promotionSet.apply(products);

        Transformer transformer = new JsonTransformer();
        Object transformedOutput = transformer.transform(products);

        DataWriter dataWriter = new FileDataWriter();
        dataWriter.write(transformedOutput);

    }

    private void applyCurrencyConversion(List<Product> products, ContentParser contentParser) {
        CurrencyConversionService currencyConversionService = new CurrencyConversionServiceImpl(contentParser);
        for(Product product : products){
            Double rate = currencyConversionService.getRate(product.getPrice().getCurrency());
            product.getPrice().setPriceInBaseCurrency(rate * product.getPrice().getValue());
        }
    }


}
