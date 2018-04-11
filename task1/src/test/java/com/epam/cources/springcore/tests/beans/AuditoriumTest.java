package com.epam.cources.springcore.tests.beans;

import com.epam.cources.springcore.beans.Auditorium;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuditoriumTest {
    private Auditorium auditorium;

    @BeforeAll
    void setUp(){
        auditorium = new Auditorium("Odeon");
    }

    @Test
    void testAuditorium(){
        Assert.assertNotNull("Instance creation failed.", auditorium);
    }

    @Test
    void testSetGetName(){
        Assert.assertEquals("Setter or getter for name field failed. Odeon " +
                "expected, got - " + auditorium.getName(), auditorium.getName(),
                "Odeon");
    }

    @Test
    void testSetGetNumberOfSeats() {
        auditorium.setNumberOfSeats(100L);
        Assert.assertEquals("Setter or getter for" +
                " numberOfSeats failed. 100 is expected, got - " + auditorium
                .getNumberOfSeats(), auditorium.getNumberOfSeats(), new Long
                (100));
    }

    @Test
    void testSetGetVipSeats(){
        List<Long> listOfVipSeats = new ArrayList<Long>();

        listOfVipSeats.addAll(Arrays.asList(10L, 20L, 30L, 40L, 50L));

        auditorium.setNumberOfSeats(100L);
        auditorium.setVipSeats(listOfVipSeats);

        Assert.assertEquals("Setter or getter for vipSeats field failed. " +
                "Size: 5 is expected, got - " + auditorium.getVipSeats().size()
                , 5, auditorium.getVipSeats().size());

        Assert.assertEquals("Setter or getter for vipSeats field failed. List" +
                " of: [10, 20, 30, 40, 50] is expected, got - " + auditorium
                .getVipSeats(), listOfVipSeats, auditorium.getVipSeats());

        Assert.assertTrue("Amount of VIP seats more than amount of seats.",
                auditorium.getVipSeats().size() <= auditorium.getNumberOfSeats());
    }
}
