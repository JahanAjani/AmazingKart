package com.fb.amazingkartapp.promotion;

import com.fb.amazingkartapp.datamodels.DiscountInfo;
import com.fb.amazingkartapp.datamodels.Product;
import com.fb.amazingkartapp.contants.DiscountType;
import com.fb.amazingkartapp.contants.ProductArrival;

import java.util.List;

public class PromotionSetB extends AbstractPromotionSet implements Promotion {
    public void apply(List<Product> products) {

        DiscountType discountType = DiscountType.PERCENTAGE;
        for (Product product : products) {
            double globalDiscount = 0.0;
            Integer discountTag = 0;
            boolean discountApplied = false;

            if (product.getInventory() > 20) {
                globalDiscount = 0.12 * product.getPrice().getPriceInBaseCurrency();
                discountTag = 12;
                discountApplied = true;
            }
            double localDiscount;
            if (product.getArrival().equals(ProductArrival.NEW)) {
                localDiscount = 0.07 * product.getPrice().getPriceInBaseCurrency();
                if (isDiscountLarge(localDiscount, globalDiscount)) {
                    globalDiscount = localDiscount;
                    discountTag = 7;
                    discountApplied = true;
                }

            }
            if(!discountApplied){
                super.applyDefaultPromotion(product);
            }else{
                product.setDiscountInfo(new DiscountInfo(globalDiscount, discountTag, discountType));
            }

        }
    }
}
