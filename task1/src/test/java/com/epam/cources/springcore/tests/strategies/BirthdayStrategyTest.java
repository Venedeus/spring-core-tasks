package com.epam.cources.springcore.tests.strategies;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.strategies.BirthdayStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BirthdayStrategyTest {
    private BirthdayStrategy strategy;
    private User user;
    private Event event;
    private LocalDateTime airDateTime;

    @BeforeAll
    void setUp() {
        strategy = new BirthdayStrategy();
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
    void testBirthdayStrategy(){
        Assert.assertNotNull("Instance creation failed.", strategy);
    }

    @Test
    void testGetDiscountBirthdayBefore(){
        user.setBirthday(LocalDate.of(1987, 03, 30));

        Assert.assertEquals("Method getDiscount() failed: 5 is expected, got " +
                        "- " + strategy.getDiscount(user, event, airDateTime, 2), 5,
                strategy.getDiscount(user, event, airDateTime, 2));
    }

    @Test
    void testGetDiscountBirthdayAfter(){
        user.setBirthday(LocalDate.of(1987, 04, 03));

        Assert.assertEquals("Method getDiscount() failed: 5 is expected, got " +
                "- " + strategy.getDiscount(user, event, airDateTime, 2), 5,
                strategy.getDiscount(user, event, airDateTime, 2));
    }

    @Test
    void testGetDiscountNotBirthDay(){
        user.setBirthday(LocalDate.of(1987, 01, 01));

        Assert.assertEquals("Method getDiscount() failed: 0 is expected, got " +
                        "- " + strategy.getDiscount(user, event, airDateTime,
                2), 0,
                strategy.getDiscount(user, event, airDateTime, 2));
    }
}
