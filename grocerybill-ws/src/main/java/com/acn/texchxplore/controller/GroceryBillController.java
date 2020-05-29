package com.acn.texchxplore.controller;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/item/bill")
public class GroceryBillController {

    @Autowired
    private GroceryService service;

    @GetMapping("/discounted")
    public GroceryBill getTotalDiscountedBill() {
        return service.getTotalDiscountedBill();
    }

    @GetMapping("/regular")
    public GroceryBill getTotalRegularbill() {
        return service.getTotalRegularBill();
    }
}
