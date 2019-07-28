package com.fb.amazingkartapp.promotion;

public class PromotionFactory {


    public static Promotion getPromotion(String promotionType) {

        Promotion promotionSet = null;
        if("promotionSetA".equalsIgnoreCase(promotionType)){
            promotionSet = new PromotionSetA();
        }else if("promotionSetB".equalsIgnoreCase(promotionType)){
            promotionSet = new PromotionSetB();
        }
        return promotionSet;
    }
}
