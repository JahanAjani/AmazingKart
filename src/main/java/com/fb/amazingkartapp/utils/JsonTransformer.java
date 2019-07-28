package com.fb.amazingkartapp.utils;

import com.fb.amazingkartapp.datamodels.Product;
import com.fb.amazingkartapp.contants.AmazingKartConstants;
import com.fb.amazingkartapp.contants.ProductArrival;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class JsonTransformer implements Transformer {
    public Object transform(List<Product> products) {

        JSONArray jsonArray = new JSONArray();

        for (Product product: products) {
            JSONObject prd = new JSONObject();
            prd.put("product", product.getName());
            prd.put("origin" , product.getOrigin().toString());
            prd.put("price", product.getPrice().getPriceInBaseCurrency());
            prd.put("currency" , AmazingKartConstants.SYSTEM_BASE_CURRENCY);
            prd.put("rating", product.getRating());
            if(product.getArrival().equals(ProductArrival.NEW)){
                prd.put("arrival", product.getArrival().toString());
            }
            prd.put("inventory", product.getInventory());
            prd.put("category", product.getCategory().toString());
            if(product.getDiscountInfo()!=null) {
                JSONObject discountNode = new JSONObject();
                discountNode.put("amount", product.getDiscountInfo().getAmount());
                discountNode.put("discountTag", product.getDiscountInfo().getDiscountTag());
                prd.put("discount", discountNode);
            }
            jsonArray.add(prd);
        }


        return jsonArray.toJSONString();
    }
}
