package com.epam.cources.springcore.tests.beans;

import com.epam.cources.springcore.beans.Item;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemTest<T extends Item> {
    private Item item;

    @BeforeAll
    void setUp(){
        item = new Item(){};
    }

    @Test
    void testItem(){
        Assert.assertNotNull("Instance creation failed.", item);
    }

    @Test
    void testSetGetId(){
        item.setId(1L);
        Assert.assertEquals("Setter of getter for id field failed. 1 is " +
                "expected, got - " + item.getId() , new Long(1), item.getId());
    }
}
