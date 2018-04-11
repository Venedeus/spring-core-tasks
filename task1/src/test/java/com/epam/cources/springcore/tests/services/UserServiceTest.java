package com.epam.cources.springcore.tests.services;

import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.daos.DAO;
import com.epam.cources.springcore.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    private UserService userService;

    @BeforeAll
    void setUp(){
        userService = new UserService(new DAO<User>() {
            @Override
            public List<User> getInputs() {
                List<User> listOfUsers = new ArrayList<>();
                User user1 = new User("ADMIN");
                user1.setEmail("admin@mail.com");

                User user2 = new User("USER");
                user2.setEmail("user1@mail.com");

                User user3 = new User("USER");
                user3.setEmail("user2@mail.com");

                listOfUsers.add(user1);
                listOfUsers.add(user2);
                listOfUsers.add(user3);

                return listOfUsers;
            }

            @Override
            public void saveInputs(List<User> listOfInputs) {

            }

            @Override
            public void saveInputs(String path, List<User> listOfInputs) {

            }
        });
    }

    @Test
    void testUserService(){
        Assert.assertNotNull("Instance creation failed.", userService);
    }

    @Test
    void testGetUserByEmail(){
        Assert.assertEquals("Method getUserByEmail() failed. id = 1 " +
                "is expected, got - " + userService.getUserByEmail
                ("user1@mail.com").getId(), new Long(2), userService
                .getUserByEmail("user1@mail.com").getId());
    }
}
