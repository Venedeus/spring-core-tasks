package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.Item;
import com.epam.cources.springcore.daos.DAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeniy on 22.03.2018.
 */
public class EventService extends Service{
    public EventService(DAO dao){
        super(dao);
    }

    public Event getByName(String name){
        return (Event) getAll().stream().filter(e -> ((Event) e).getName()
                .equals(name)).findFirst().orElse(null);
    }

    public List<Event> getDateFromRange(LocalDate fromDate, LocalDate toDate){
        List<Event> listOfEvents = new ArrayList<>();

        for(Item item: getAll()){
            for(LocalDateTime dateTime: ((Event) item).getSchedule()){
                if(dateTime.toLocalDate().isAfter(fromDate.minusDays(1)) && dateTime.toLocalDate().isBefore(toDate.plusDays(1))){
                    listOfEvents.add((Event) item);
                }
            }

        }
        return listOfEvents;
    }

    public List<Event> getNextEvents(LocalDate toDate){
        return getDateFromRange(LocalDate.now(), toDate);
    }
}
