package com.fb.amazingkartapp.contants;

import java.util.EnumSet;

public enum ProductCategory {

    ELECTRONICS("electronics"),
    CLOTHING("clothing"),
    GROOMING("grooming"),
    ACCESSORIES("accessories"),
    TOYS("toys"),
    BOOKS("books"),
    APPARELS("apparels"),
    HOME("home"),
    FURNISHING("furnishing");

    private final String label;

    ProductCategory(String label) {
            this.label = label;
        }

        public static ProductCategory ofValue(String category) {
            for (ProductCategory productCategory : EnumSet.allOf(ProductCategory.class)) {
                if (productCategory.label.equalsIgnoreCase(category)) return productCategory;
            }
            //LOGGER.warn("Indicator {} cannot be resolved for value {}", enumClass.getSimpleName(), countryValue);
            return null;
        }

        @Override
        public String toString() {
            return label;
        }

}
