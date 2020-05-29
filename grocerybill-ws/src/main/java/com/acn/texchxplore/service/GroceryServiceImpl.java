package com.acn.texchxplore.service;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.entity.ShoppingClerk;
import com.acn.texchxplore.impl.DiscountedBill;
import com.acn.texchxplore.impl.RegularBill;
import com.acn.texchxplore.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class GroceryServiceImpl implements GroceryService {

    private ItemRepository itemRepo;
    private ShoppingClerk shoppingClerk;

    public GroceryServiceImpl(ItemRepository itemRepo) {
        this.itemRepo=itemRepo;
        this.shoppingClerk = new ShoppingClerk("TechXplore");
    }

    @Override
    public GroceryBill getTotalDiscountedBill() {
        GroceryBill grocery = new DiscountedBill(shoppingClerk);
        grocery.setItemList(itemRepo.findByDiscounted(true));
        return grocery;
    }

    @Override
    public GroceryBill getTotalRegularBill() {
        GroceryBill grocery = new RegularBill(shoppingClerk);
        grocery.setItemList(itemRepo.findByDiscounted(false));
        return grocery;
    }
}
