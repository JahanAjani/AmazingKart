package com.fb.amazingkartapp.promotion;

import com.fb.amazingkartapp.datamodels.DiscountInfo;
import com.fb.amazingkartapp.datamodels.Product;
import com.fb.amazingkartapp.contants.DiscountType;

public class AbstractPromotionSet {

    protected void applyDefaultPromotion(Product product) {
        if(product.getPrice().getPriceInBaseCurrency() > 1000.0){
            product.setDiscountInfo(new DiscountInfo(0.02 * product.getPrice().getPriceInBaseCurrency(), 2, DiscountType.PERCENTAGE));
        }
    }

    protected boolean isDiscountLarge(double localDiscount, double globalDiscount){
        return localDiscount > globalDiscount;
    }
}
