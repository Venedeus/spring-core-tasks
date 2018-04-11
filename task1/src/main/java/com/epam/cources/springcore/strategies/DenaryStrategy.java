package com.epam.cources.springcore.strategies;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.User;

import javax.xml.bind.SchemaOutputResolver;
import java.time.LocalDateTime;

public class DenaryStrategy implements Strategy {
    @Override
    public int getDiscount(User user, Event event, LocalDateTime dateTime, int numberOfTickets) {
        int discount = 0;

        if(user.isRegistered()){
            int toBuy = (int) (((int) user.getTickets().longValue() / 10 + 1)
                    * 10 - user.getTickets().longValue()) ;

            if(toBuy <= numberOfTickets){
                int delta = (numberOfTickets - toBuy) / 10 + 1;
                discount = delta * 50 / numberOfTickets;
            }
        }
        else{
            if(numberOfTickets >= 10) {
                discount = 50 / numberOfTickets;
            }
        }

        return discount;
    }
}
