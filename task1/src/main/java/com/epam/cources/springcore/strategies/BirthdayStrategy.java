package com.epam.cources.springcore.strategies;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;

import java.time.LocalDateTime;

public class BirthdayStrategy implements Strategy {
    @Override
    public int getDiscount(User user, Event event, LocalDateTime dateTime, int numberOfTickets) {
        int discount = 0;

        if(Math.abs(user.getBirthday().getDayOfYear() - dateTime.toLocalDate().getDayOfYear()) <= 5){
            discount = 5;
        }

        return discount;
    }
}
