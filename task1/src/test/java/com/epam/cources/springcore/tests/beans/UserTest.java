package com.epam.cources.springcore.tests.beans;

import com.epam.cources.springcore.beans.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {
    private User user;

    @BeforeAll
    void setUp(){
        user = new User("user");
    }

    @Test
    void testSetGetEmail(){
        user.setEmail("venedey.e@gmail.com");

        Assert.assertEquals("Setter or getter failed. venedey.e@gmail.com " +
                "expected, got - " + user.getEmail(),"venedey.e@gmail.com",
                user.getEmail());
    }

    @Test
    void testGetRole(){
        Assert.assertEquals("Method getRole() failed. USER - expected, got - " +
                "" + user.getRole(), "USER", user.getRole());
    }
}
