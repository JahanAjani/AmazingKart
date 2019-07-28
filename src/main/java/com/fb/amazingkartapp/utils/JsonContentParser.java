package com.fb.amazingkartapp.utils;

import com.fb.amazingkartapp.datamodels.Price;
import com.fb.amazingkartapp.datamodels.Product;
import com.fb.amazingkartapp.contants.AmazingKartConstants;
import com.fb.amazingkartapp.contants.Country;
import com.fb.amazingkartapp.contants.ProductArrival;
import com.fb.amazingkartapp.contants.ProductCategory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class JsonContentParser implements ContentParser {

    public JSONArray parse(String content){
        JSONArray httpContentToJson=null;
        try {
            JSONParser parser = new JSONParser();
            httpContentToJson = (JSONArray) parser.parse(content);
        } catch (ParseException e) {
            e.printStackTrace();
            // invaild data.
        }
        return httpContentToJson;
    }

    public List parseToList(Object productsInformation) {
        if(productsInformation instanceof JSONArray){

            List<Product> products = new ArrayList<Product>();
            JSONObject prod = null;
            for( int i =0; i<((JSONArray) productsInformation).size(); i++){
                prod  = (JSONObject)((JSONArray) productsInformation).get(i);
                Product product = new Product();
                product.setName(prod.get("product").toString());
                product.setOrigin(Country.ofValue(prod.get("origin").toString()));

                Price price = new Price(Double.parseDouble(prod.get("price").toString()), prod.get("currency").toString());
                if(prod.get("currency").toString().equalsIgnoreCase(AmazingKartConstants.SYSTEM_BASE_CURRENCY)){
                    price.setPriceInBaseCurrency(price.getValue());
                }
                product.setPrice(price);
                product.setRating(Double.parseDouble(prod.get("rating").toString()));
                product.setInventory(Integer.parseInt(prod.get("inventory").toString()));
                product.setCategory(ProductCategory.ofValue(prod.get("category").toString()));

                if(prod.get("arrival")!=null) {
                    product.setArrival(ProductArrival.ofValue(prod.get("arrival").toString()));
                }

                products.add(product);
            }

            return products;

        }else{
            return null;
        }
    }

    public Double parseExchangeRate(Object rateInformation, String currency) {

        JSONParser parser = new JSONParser();
        JSONObject parsedObject = null;
        try {
            parsedObject = (JSONObject) parser.parse((String)rateInformation);
            JSONObject rates = (JSONObject) parsedObject.get("rates");
            return (Double) rates.get(currency);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 1D;
    }
}
