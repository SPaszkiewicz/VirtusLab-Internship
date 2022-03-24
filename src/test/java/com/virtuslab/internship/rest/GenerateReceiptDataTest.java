package com.virtuslab.internship.rest;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.ProductDb;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GenerateReceiptDataTest {

    @Test
    void showReceipt() {
        Basket basket = new Basket();
        ProductDb productDb = new ProductDb();
        var apple = productDb.getProduct("Apple");
        var cereals = productDb.getProduct("Cereals");
        var steak = productDb.getProduct("Steak");
        var onion = productDb.getProduct("Onion");
        basket.addProduct(apple);
        basket.addProduct(apple);
        basket.addProduct(apple);
        basket.addProduct(cereals);
        basket.addProduct(steak);
        basket.addProduct(steak);
        basket.addProduct(onion);
        var expectedTotalCost = apple.price()
                .multiply(BigDecimal.valueOf(3))
                .add(cereals.price())
                .add(steak.price().multiply(BigDecimal.valueOf(2)))
                .add(onion.price())
                .multiply(BigDecimal.valueOf(0.9));

        GenerateReceiptData generateReceiptData = new GenerateReceiptData();
        var receipt = generateReceiptData.showReceipt(basket);
        assertEquals(expectedTotalCost, receipt.totalPrice());
        assertEquals("TenPercentDiscount", receipt.discounts().get(0));
        assertEquals(1, receipt.discounts().size());
    }
}