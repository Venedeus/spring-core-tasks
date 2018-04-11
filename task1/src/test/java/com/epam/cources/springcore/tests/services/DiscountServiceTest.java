package com.epam.cources.springcore.tests.services;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.services.DiscountService;
import com.epam.cources.springcore.strategies.BirthdayStrategy;
import com.epam.cources.springcore.strategies.DenaryStrategy;
import com.epam.cources.springcore.strategies.Strategy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DiscountServiceTest {
    private DiscountService service;
    private User user;
    private Event event;
    private LocalDateTime airDateTime;


    @BeforeAll
    void setUp(){
        List<Strategy> listOfStrategies = new ArrayList<>();
        listOfStrategies.add(new BirthdayStrategy());
        listOfStrategies.add(new DenaryStrategy());

        service = new DiscountService(listOfStrategies);

        airDateTime = LocalDateTime.of(LocalDate.of(2018,
                04, 01), LocalTime.of(11, 00));

        user = new User("USER");
        user.setId(new Long(1L));
        user.setEmail("user@email.com");
        user.setTickets(new Long(9));
        user.setBirthday(LocalDate.of(1987, 04, 02));

        event = new Event("Movie #1");
        event.setId(new Long(1L));
        event.setBasePrice(new BigDecimal(10L));
        event.setRating("HIGH");
        event.setAuditoriumId(new Long(1L));
        event.addDate(airDateTime);
    }

    @Test
    void testDiscountStrategy(){
        Assert.assertNotNull("Instance creation failed.", service);
    }

    @Test
    void testGetDiscountBothStrategies(){
        user.setTickets(new Long(6));
        user.setBirthday(LocalDate.of(1987, 04, 02));

        Assert.assertEquals("Method getDiscount() failed: 10 is expected," +
                " got - " + service.getDiscount(user, event, airDateTime,
                5), 10, service.getDiscount(user, event, airDateTime,
                5));
    }

    @Test
    void testGetDiscountBirthdayStrategy(){
        user.setTickets(new Long(3));
        user.setBirthday(LocalDate.of(1987, 04, 02));

        Assert.assertEquals("Method getDiscount() failed: 5 is expected," +
                " got - " + service.getDiscount(user, event, airDateTime,
                5), 5, service.getDiscount(user, event, airDateTime,
                5));
    }

    @Test
    void testGetDiscountDenaryStrategy(){
        user.setTickets(new Long(6));
        user.setBirthday(LocalDate.of(1987, 01, 01));

        Assert.assertEquals("Method getDiscount() failed: 10 is expected," +
                " got - " + service.getDiscount(user, event, airDateTime,
                5), 10, service.getDiscount(user, event, airDateTime,
                5));
    }

    @Test
    void testGetDiscountNoneStrategy(){
        user.setTickets(new Long(3));
        user.setBirthday(LocalDate.of(1987, 01, 01));

        Assert.assertEquals("Method getDiscount() failed: 0 is expected," +
                " got - " + service.getDiscount(user, event, airDateTime,
                5), 0, service.getDiscount(user, event, airDateTime,
                5));
    }
}
