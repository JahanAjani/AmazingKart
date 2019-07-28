package com.fb.amazingkartapp.promotion;

import com.fb.amazingkartapp.datamodels.Product;

import java.util.List;

public interface Promotion {

    void apply(List<Product> products);
}
