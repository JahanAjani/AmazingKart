package com.fb.amazingkartapp.utils;

import com.fb.amazingkartapp.datamodels.Product;

import java.util.List;

public interface Transformer {
    Object transform(List<Product> products);
}
