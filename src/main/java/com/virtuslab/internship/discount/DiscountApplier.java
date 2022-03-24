package com.virtuslab.internship.discount;

import com.virtuslab.internship.receipt.Receipt;

public class DiscountApplier {
    private final IDiscount fifteenDiscount = new FifteenPercentDiscount();
    private final IDiscount tenDiscount = new TenPercentDiscount();

    public Receipt applyDiscounts(Receipt receipt) {
        Receipt newReceipt;
        newReceipt = fifteenDiscount.apply(receipt);
        newReceipt = tenDiscount.apply(newReceipt);
        return newReceipt;
    }
}
