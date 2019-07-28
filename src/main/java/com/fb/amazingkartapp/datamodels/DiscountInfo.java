package com.fb.amazingkartapp.datamodels;

import com.fb.amazingkartapp.contants.AmazingKartConstants;
import com.fb.amazingkartapp.contants.DiscountType;

public class DiscountInfo {

    private Double amount;
    private Integer discountTag;
    private DiscountType discountType;

    public DiscountInfo(Double amount, Integer discountTag, DiscountType discountType){
        this.amount = amount;
        this.discountTag = discountTag;
        this.discountType = discountType;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDiscountTag() {
        StringBuilder s = new StringBuilder();
        s.append("get ");
        if(discountType == DiscountType.FLAT_OFF){
            s.append(AmazingKartConstants.SYSTEM_BASE_CURRENCY);
            s.append(" ");
            s.append(discountTag);
            s.append(" ");
        }else if(discountType == DiscountType.PERCENTAGE){
            s.append(discountTag);
            s.append("% ");
        }
        s.append("off");
        return s.toString();
    }
}
