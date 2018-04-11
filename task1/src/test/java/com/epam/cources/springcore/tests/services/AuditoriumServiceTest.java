package com.epam.cources.springcore.tests.services;

import com.epam.cources.springcore.beans.Auditorium;
import com.epam.cources.springcore.daos.DAO;
import com.epam.cources.springcore.services.AuditoriumService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuditoriumServiceTest {
    private AuditoriumService auditoriumService;

    @BeforeAll
    void setUp(){
        auditoriumService = new AuditoriumService(new DAO() {
            @Override
            public List getInputs() {
                List<Auditorium> listOfAuditoriums = new ArrayList<>();
                List<Long> listOfVipSeats = new ArrayList<>();

                listOfVipSeats.addAll(Arrays.asList(10L, 20L, 30L, 40L, 50L,
                        60L, 70L, 80L, 90L));

                Auditorium auditorium1 = new Auditorium("Auditorium #1");
                auditorium1.setNumberOfSeats(new Long(100));
                auditorium1.setVipSeats(listOfVipSeats);

                Auditorium auditorium2 = new Auditorium("Auditorium #2");
                auditorium2.setNumberOfSeats(new Long(100));
                auditorium2.setVipSeats(listOfVipSeats);

                Auditorium auditorium3 = new Auditorium("Auditorium #3");
                auditorium3.setNumberOfSeats(new Long(100));
                auditorium3.setVipSeats(listOfVipSeats);

                listOfAuditoriums.add(auditorium1);
                listOfAuditoriums.add(auditorium2);
                listOfAuditoriums.add(auditorium3);

                return listOfAuditoriums;
            }

            @Override
            public void saveInputs(List listOfInputs) {

            }

            @Override
            public void saveInputs(String path, List listOfInputs) {

            }
        });
    }

    @Test
    void testAuditoriumService(){
        Assert.assertNotNull("Instance crezation failed.", auditoriumService);
    }

    @Test
    void testGetByName(){
        Assert.assertEquals("Method getByName() failed. Auditorium #1 is " +
                "expected, got - " + auditoriumService.getByName
                ("Auditorium #1"), "Auditorium #1", auditoriumService.getByName
                ("Auditorium #1").getName());
    }
}
