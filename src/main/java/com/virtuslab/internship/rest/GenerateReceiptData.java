package com.virtuslab.internship.rest;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.DiscountApplier;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateReceiptData {
    private  final ReceiptGenerator receiptGenerator = new ReceiptGenerator();
    private final DiscountApplier discountApplier = new DiscountApplier();
    public GenerateReceiptData() {
    }

    @GetMapping
    public Receipt showReceipt(Basket basket){
        Receipt receipt = receiptGenerator.generate(basket);
        receipt = discountApplier.applyDiscounts(receipt);
        return receipt;
    }
}
