package com.virtuslab.internship.product;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(
        String name,
        Type type,
        BigDecimal price

) {
    @Override
    public int hashCode() {
        return Objects.hash(name, type, price);
    }

    public enum Type {
        DAIRY, FRUITS, VEGETABLES, MEAT, GRAINS
    }
}
