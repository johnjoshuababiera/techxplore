package com.acn.texchxplore.service;

import com.acn.texchxplore.domain.GroceryBill;

public interface GroceryService {
    GroceryBill getTotalDiscountedBill();
    GroceryBill getTotalRegularBill();
}
