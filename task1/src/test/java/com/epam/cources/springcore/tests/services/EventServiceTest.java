package com.epam.cources.springcore.tests.services;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.daos.DAO;
import com.epam.cources.springcore.services.EventService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventServiceTest {
    private EventService eventService;

    @BeforeEach
    void setUp(){
        eventService = new EventService(new DAO<Event>() {
            @Override
            public List<Event> getInputs() {
                List<Event> listOfEvents = new ArrayList<>();

                Event event1 = new Event("Movie #1");
                event1.setBasePrice(new BigDecimal(10));
                event1.setAuditoriumId(new Long(1));
                event1.addDate(LocalDateTime.of(LocalDate.of(2018, 04, 01),
                        LocalTime.of(11, 00)));
                event1.setRating("HIGH");

                Event event2 = new Event("Movie #2");
                event2.setBasePrice(new BigDecimal(5));
                event2.setAuditoriumId(new Long(2));
                event1.addDate(LocalDateTime.of(LocalDate.of(2018, 03, 02),
                        LocalTime.of(12, 00)));
                event2.setRating("MID");

                Event event3 = new Event("Movie #3");
                event2.setBasePrice(new BigDecimal(7));
                event2.setAuditoriumId(new Long(3));
                event1.addDate(LocalDateTime.of(LocalDate.of(2018, 04, 02),
                        LocalTime.of(13, 00)));
                event2.setRating("LOW");

                listOfEvents.add(event1);
                listOfEvents.add(event2);
                listOfEvents.add(event3);

                return listOfEvents;
            }

            @Override
            public void saveInputs(List<Event> listOfInputs) {

            }

            @Override
            public void saveInputs(String path, List<Event> listOfInputs) {

            }
        });
    }

    @Test
    void testEventService(){
        Assert.assertNotNull("Instance creation failed.", eventService);
    }

    @Test
    void testGetByName(){
        Assert.assertEquals("Method getByName() failed. Movie #2 is expected," +
                " got - " + eventService.getByName("Movie #2"), "Movie #2",
                eventService.getByName("Movie #2").getName());
    }

    @Test
    void testGetDateFromRange(){
        LocalDate fromDate = LocalDate.of(2018, 04, 01);
        LocalDate toDate = LocalDate.of(2018, 04,10);

        Assert.assertEquals("Method getDateFromRange() failed. 2 events are " +
                "expected, got - " + eventService.getDateFromRange(fromDate,
                toDate).size(), 2, eventService.getDateFromRange(fromDate,
                toDate).size());
    }

    @Test
    void testGetNextEvents(){
        eventService.getAll().stream().forEach(e -> {
            ((Event) e).getSchedule().clear();
            ((Event) e).addDate(LocalDateTime.of(LocalDate.now().plusDays
                    (((Event) e).getId() + 1), LocalTime.of(11, 00)));
        } );

        Assert.assertEquals("Method getNextEvents() failed. 2 events are " +
                "expected, got - ", + eventService.getNextEvents(LocalDate
                .now().plusDays(2)).size(), 2, eventService.getNextEvents(LocalDate
                .now().plusDays(2)).size());
    }
}
