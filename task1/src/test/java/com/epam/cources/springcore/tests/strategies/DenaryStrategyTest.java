package com.epam.cources.springcore.tests.strategies;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.strategies.BirthdayStrategy;
import com.epam.cources.springcore.strategies.DenaryStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DenaryStrategyTest {
    private DenaryStrategy strategy;
    private User user;
    private Event event;
    private LocalDateTime airDateTime;

    @BeforeAll
    void setUp(){
        strategy = new DenaryStrategy();

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
    void testDenaryStrategy(){
        Assert.assertNotNull("Instance creation failed.", strategy);
    }

    @Test
    void testGetDiscountMoreTenTickets(){
        user.setTickets(new Long(9));
        Assert.assertEquals("Method getDiscount() failed: 25 is expected, got" +
                        " - " + strategy.getDiscount(user, event, airDateTime,2),
                25, strategy.getDiscount(user, event, airDateTime, 2));
    }

    @Test
    void testGetDiscountMoreTwentyTickets(){
        user.setTickets(new Long(9));
        Assert.assertEquals("Method getDiscount() failed: 25 is expected, got" +
                        " - " + strategy.getDiscount(user, event,
                airDateTime,11),9,
                strategy.getDiscount(user, event, airDateTime, 11));
    }

    @Test
    void testGetDiscountLessTenTickets(){
        user.setTickets(new Long(5));

        Assert.assertEquals("Method getDiscount() failed: 0 is expected, got" +
                        " - " + strategy.getDiscount(user, event, airDateTime,2),
                0, strategy.getDiscount(user, event, airDateTime, 2));
    }
}
