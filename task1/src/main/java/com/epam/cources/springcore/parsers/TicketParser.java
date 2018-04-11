package com.epam.cources.springcore.parsers;

import com.epam.cources.springcore.beans.Ticket;
import org.json.simple.JSONObject;

import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TicketParser extends JsonParser<Ticket>{
    public TicketParser() {
    }

    public TicketParser(Reader reader) {
        super(reader);
    }

    @Override
    public Ticket parseInstance(JSONObject jsonObject) {
        Ticket ticket = new Ticket((String) jsonObject.get("ticketStatus"));
        ticket.setId((Long) jsonObject.get("id"));
        ticket.setEventId((Long) jsonObject.get("eventId"));
        ticket.setAirDateTime(parseLocalDateTime((JSONObject) jsonObject.get
                ("airDateTime")));
        ticket.setSeat((Long) jsonObject.get("seat"));
        ticket.setUserId((Long) jsonObject.get("userId"));

        return ticket;
    }
}
