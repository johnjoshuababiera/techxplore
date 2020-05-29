package com.acn.texchxplore.service;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.entity.Item;
import com.acn.texchxplore.repository.ItemRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
class GroceryServiceIntegrationTest {

    private static final double DELTA = 1e-15;


    @Autowired
    private ItemRepository repository;
    @Autowired
    private GroceryService groceryService;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void getTotalDiscountedBill() {
        Item item1 = new Item("Panteen Shampoo", 25.00, false, 0.00);
        Item item2 = new Item("Creamsilk Conditioner", 30.00, false, 0.00);
        Item item3 = new Item("Colgate Toothpaste", 100.00, true, 10.00);
        repository.saveAll(Arrays.asList(item1,item2,item3));
        GroceryBill groceryBill = groceryService.getTotalDiscountedBill();
        Assert.assertEquals(90d, groceryBill.getTotalBill(), DELTA);
        Assert.assertNotNull( groceryBill.getItemList());
        Assert.assertEquals(1, groceryBill.getItemList().size());
        Assert.assertNotNull( groceryBill.getClerk());
        Assert.assertEquals("TechXplore", groceryBill.getClerk().getName());

    }

    @Test
    void getTotalRegularBill() {
        Item item1 = new Item("Panteen Shampoo", 25.00, false, 0.00);
        Item item2 = new Item("Creamsilk Conditioner", 30.00, false, 0.00);
        Item item3 = new Item("Colgate Toothpaste", 100.00, true, 10.00);

        repository.saveAll(Arrays.asList(item1,item2, item3));
        GroceryBill groceryBill = groceryService.getTotalRegularBill();
        Assert.assertEquals(55d, groceryBill.getTotalBill(), DELTA);
        Assert.assertNotNull( groceryBill.getItemList());
        Assert.assertEquals(2, groceryBill.getItemList().size());
        Assert.assertNotNull( groceryBill.getClerk());
        Assert.assertEquals("TechXplore", groceryBill.getClerk().getName());

    }
}