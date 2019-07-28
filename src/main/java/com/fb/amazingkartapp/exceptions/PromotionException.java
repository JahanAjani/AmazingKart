package com.fb.amazingkartapp.exceptions;

public class PromotionException extends Exception {

    public PromotionException(String message){
        super(message);
    }

    public PromotionException(String message, Throwable cause){
        super(message, cause);
    }
}
