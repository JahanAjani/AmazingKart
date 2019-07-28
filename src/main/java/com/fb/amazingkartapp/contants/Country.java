package com.fb.amazingkartapp.contants;

import java.util.EnumSet;

public enum Country {
    ASIA("Asia"),
    EUROPE("Europe"),
    AMERICA("America"),
    AFRICA("Africa");

    private final String label;

    Country(String label) {
        this.label = label;
    }

    public static Country ofValue(String countryValue) {
        for (Country country : EnumSet.allOf(Country.class)) {
            if (country.label.equalsIgnoreCase(countryValue)) return country;
        }
        //LOGGER.warn("Indicator {} cannot be resolved for value {}", enumClass.getSimpleName(), countryValue);
        return null;
    }

    @Override
    public String toString() {
        return label;
    }
}
