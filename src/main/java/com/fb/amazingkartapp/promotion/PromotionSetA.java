package com.fb.amazingkartapp.promotion;

import com.fb.amazingkartapp.datamodels.DiscountInfo;
import com.fb.amazingkartapp.datamodels.Product;
import com.fb.amazingkartapp.contants.Country;
import com.fb.amazingkartapp.contants.DiscountType;
import com.fb.amazingkartapp.contants.ProductCategory;

import java.util.List;

public class PromotionSetA extends AbstractPromotionSet implements Promotion {
    public void apply(List<Product> products) {

        for (Product product : products) {
            double globalDiscount = 0.0;
            Integer discountTag = 0;
            boolean discountApplied = false;
            DiscountType discountType = DiscountType.PERCENTAGE;
            if (product.getOrigin() == Country.AFRICA) {
                globalDiscount = 0.07 * product.getPrice().getPriceInBaseCurrency();
                discountTag = 7;
                discountApplied = true;
            }
            double localDiscount;
            if (product.getRating() == 2) {
                localDiscount = 0.04 * product.getPrice().getPriceInBaseCurrency();
                if (isDiscountLarge(localDiscount, globalDiscount)) {
                    globalDiscount = localDiscount;
                    discountTag = 4;
                    discountApplied = true;
                }

            } else if (product.getRating() < 2) {
                localDiscount = 0.08 * product.getPrice().getPriceInBaseCurrency();
                if (isDiscountLarge(localDiscount, globalDiscount)) {
                    globalDiscount = localDiscount;
                    discountTag = 8;
                    discountApplied = true;
                }
            }

            if ((product.getCategory() == ProductCategory.ELECTRONICS ||
                    product.getCategory() == ProductCategory.FURNISHING) && product.getPrice().getPriceInBaseCurrency() >= 500.0) {
                localDiscount = 100.0;
                if (isDiscountLarge(localDiscount, globalDiscount)) {
                    globalDiscount = localDiscount;
                    discountTag = 100;
                    discountType = DiscountType.FLAT_OFF;
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
