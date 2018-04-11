package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.strategies.Strategy;

import java.time.LocalDateTime;
import java.util.List;

public class DiscountService {
    private List<Strategy> listOfStrategies;

    public DiscountService(List<Strategy> listOfStrategies) {
        this.listOfStrategies = listOfStrategies;
    }

    public int getDiscount(User user, Event event, LocalDateTime dateTime,
                           int numberOfTickets){
        return listOfStrategies.stream().mapToInt(s -> s.getDiscount(user,
                event,
                dateTime, numberOfTickets)).max().getAsInt();
    }
}
