package com.fb.amazingkartapp.contants;

import java.util.EnumSet;

public enum ProductArrival {

    NEW("NEW"),
    OLD("OLD");

    private final String label;

    ProductArrival(String label) {
        this.label = label;
    }

    public static ProductArrival ofValue(String category) {
        for (ProductArrival productArrival : EnumSet.allOf(ProductArrival.class)) {
            if (productArrival.label.equalsIgnoreCase(category)) return productArrival;
        }
        //LOGGER.warn("Indicator {} cannot be resolved for value {}", enumClass.getSimpleName(), countryValue);
        return null;
    }

    @Override
    public String toString() {
        return label;
    }


}
