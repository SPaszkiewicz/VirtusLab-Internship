package com.virtuslab.internship.receipt;
import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        Map<String, Integer> countProducts = basket.getProducts()
                .stream()
                .collect(toMap(Product::name, v -> 1, Math::addExact));

        List<ReceiptEntry> receiptEntries = basket.getProducts()
                                                    .stream()
                                                    .distinct()
                                                    .map(product -> new ReceiptEntry(product, countProducts.get(product.name())))
                                                    .collect(Collectors.toList());
        return new Receipt(receiptEntries);
    }
}
