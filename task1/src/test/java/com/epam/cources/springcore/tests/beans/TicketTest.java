package com.epam.cources.springcore.tests.beans;

import com.epam.cources.springcore.beans.Ticket;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicketTest {
    private Ticket ticket;

    @BeforeAll
    void setUp(){
        ticket = new Ticket();
    }

    @Test
    void testTicket(){
        Assert.assertNotNull("Instance creation failed.", ticket);
    }

    @Test
    void testSetGetEventId(){
        ticket.setEventId(1L);

        Assert.assertEquals("Setter or getter for eventId field failed. 1 is " +
                "expected, got - " + ticket.getEventId(), new Long(1), ticket.getEventId());
    }

    @Test
    void testSetGetAirDateTime(){
        ticket.setAirDateTime(LocalDateTime.of(LocalDate.of(2018, 04, 01),
                LocalTime.of(11, 00)));

        Assert.assertTrue("Setter or getter for airDateTIme field failed. " +
                "2018-04-01T11:00 is expected, got - " + ticket
                .getAirDateTime(), ticket.getAirDateTime().isEqual(
                LocalDateTime.of(LocalDate.of(2018, 04, 01),
                        LocalTime.of(11, 00))));
    }

    @Test
    void testSetGetUserId(){
        ticket.setUserId(10L);

        Assert.assertEquals("Setter or getter for userId field failed. 10 is " +
                "expected, got - " + ticket.getUserId(), new Long(10), ticket.getUserId());
    }

    @Test
    void testSetGetTicketStatus(){
        ticket = new Ticket();

        Assert.assertEquals("Getter for ticketStatus field failed. FREE - is " +
                "expected, got - " + ticket.getTicketStatus(), "FREE",
                ticket.getTicketStatus());
    }

    @Test
    void testPurchaseTicket(){
        ticket.purchaseTicket();

        Assert.assertEquals("Method purchaseTicket() failed. PURCHASED is expected," +
                " got - " + ticket.getTicketStatus(), "PURCHASED",
                ticket.getTicketStatus());
    }

    @Test
    void testBookTicket(){
        ticket.bookTicket();

        Assert.assertEquals("Method bookTicket() failed. BOOKED is expected, got - " +
                ticket.getTicketStatus(), "BOOKED", ticket.getTicketStatus());
    }

    @Test
    void testIsPurchased(){
        ticket = new Ticket();
        ticket.purchaseTicket();

        Assert.assertEquals("Method isPurchased() failed. PURCHASED is " +
                "expected, got - " + ticket.getTicketStatus(), "PURCHASED",
                ticket.getTicketStatus());

    }
}