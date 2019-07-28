package com.fb.amazingkartapp.datamodels;

import com.fb.amazingkartapp.contants.Country;
import com.fb.amazingkartapp.contants.ProductArrival;
import com.fb.amazingkartapp.contants.ProductCategory;

/**
 * {"product":"XTP mobile","origin":"Asia","price":2500,
 * "currency":"INR","rating":3.8,"inventory":10,"category":"electronics"}
 **/
public class Product {
    private String name;
    private Country origin;
    private Price price;
    private Double rating;
    private Integer inventory;
    private ProductCategory category;
    private ProductArrival arrival = ProductArrival.OLD;
    private boolean isPromotionalDiscountApplicable;
    private DiscountInfo discountInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getInventory() {
        return inventory;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public ProductArrival getArrival() {
        return arrival;
    }

    public void setArrival(ProductArrival arrival) {
        this.arrival = arrival;
    }

    public DiscountInfo getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(DiscountInfo discountInfo) {
        this.discountInfo = discountInfo;
    }

    public boolean isPromotionalDiscountApplicable() {
        return isPromotionalDiscountApplicable;
    }

    public void setPromotionalDiscountApplicable(boolean promotionalDiscountApplicable) {
        isPromotionalDiscountApplicable = promotionalDiscountApplicable;
    }
}
