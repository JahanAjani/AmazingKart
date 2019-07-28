package com.fb.amazingkartapp;

import com.fb.amazingkartapp.exceptions.PromotionException;
import com.fb.amazingkartapp.promotion.Promotion;
import com.fb.amazingkartapp.promotion.PromotionFactory;

public class StartUp {

    public static void main(String[] args){

        try {
            Promotion promotionSet = PromotionFactory.getPromotion(args[0]);
            AmazingKart amazingCart = new AmazingKart(promotionSet);
            amazingCart.execute();
        } catch (PromotionException e) {
            e.printStackTrace();
        }
    }
}
