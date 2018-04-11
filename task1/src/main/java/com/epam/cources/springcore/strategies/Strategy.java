package com.epam.cources.springcore.strategies;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;

import java.time.LocalDateTime;

public interface Strategy {
    int getDiscount(User user, Event event, LocalDateTime dateTime,
                           int numberOfTickets);
}
