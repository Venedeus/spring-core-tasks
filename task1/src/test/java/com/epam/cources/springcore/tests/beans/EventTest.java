package com.epam.cources.springcore.tests.beans;

import com.epam.cources.springcore.beans.Event;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventTest {
    private Event event;

    @BeforeAll
    void setUp(){
        event = new Event("Rock concert");
    }

    @Test
    void testEvent(){
        Assert.assertNotNull("Instance creation failed.", event);
    }

    @Test
    void testSetGetBasePrice(){
        event.setBasePrice(new BigDecimal(10));

        Assert.assertEquals(
                "Setter or getter for basePrice field failed. 10 is expected," +
                        " got "+
                        event.getBasePrice(), new BigDecimal(10), event.getBasePrice());
    }

    @Test
    void testSetGetRating(){
        event.setRating("HIGH");

        Assert.assertEquals("Setter or getter for rating field failed. HIGH " +
                "expected, got - " + event.getRating(), "HIGH", event.getRating());
    }

    @Test
    void testSetGetAuditoriumId(){
        event.setAuditoriumId(10L);

        Assert.assertEquals("Setter or getter for auditoriumId field failed. " +
                "10 is expected, got - " + event.getAuditoriumId(), new Long(10),
                event.getAuditoriumId());
    }

    @Test
    void testAddDate(){
        event.addDate(LocalDateTime.now());

        Assert.assertEquals("Method addDate() failed. 1 expected, got - " +
                event.getSchedule().size(), 1, event.getSchedule().size());
    }

    @Test
    void testGetSchedule(){
        event.getSchedule().clear();
        event.addDate(LocalDateTime.of(LocalDate.of(2018, 03, 01), LocalTime
                .of(11, 00)));

        Assert.assertTrue("Method getSchedule() failed. Expected 1, date: " +
                "[2018-03-01 11:00], got - " + event.getSchedule().size() +
                        ", date: " + event.getSchedule().get(0),
                event.getSchedule().size() == 1
                && event.getSchedule().get(0).isEqual(LocalDateTime.of
                (LocalDate.of(2018, 03, 01), LocalTime.of(11, 00))));
    }
}
