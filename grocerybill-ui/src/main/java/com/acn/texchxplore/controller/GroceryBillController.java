package com.acn.texchxplore.controller;

import com.acn.texchxplore.model.GroceryBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GroceryBillController {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/techxplore/grocery")
    public String getIndexPage(Model model) {
        GroceryBill discountedGroceries = this.restTemplate.getForObject("http://localhost:9090/item/bill/discounted", GroceryBill.class);
        GroceryBill regular = this.restTemplate.getForObject("http://localhost:9090/item/bill/regular", GroceryBill.class);
        model.addAttribute("regularBill", discountedGroceries);
        model.addAttribute("discountedBill", regular);
        model.addAttribute("clerk", regular.getClerk());
        return "grocery";
    }

}
