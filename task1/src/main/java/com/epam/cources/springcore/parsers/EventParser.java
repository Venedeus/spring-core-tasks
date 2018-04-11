package com.epam.cources.springcore.parsers;

import com.epam.cources.springcore.beans.Event;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Reader;
import java.math.BigDecimal;
import java.util.*;

public class EventParser extends JsonParser<Event> {
    public EventParser() {
    }

    public EventParser(Reader reader) {
        super(reader);
    }

    @Override
    public Event parseInstance(JSONObject jsonObject) {
        Event event = new Event((String) jsonObject.get("name"));
        event.setId((Long) jsonObject.get("id"));
        event.setAuditoriumId((Long) jsonObject.get("auditoriumId"));
        event.setRating((String) jsonObject.get("rating"));
        event.setBasePrice(new BigDecimal((Long) jsonObject.get("basePrice")));

        Iterator<JSONObject> it = ((JSONArray) jsonObject.get("schedule")).iterator();

        while(it.hasNext()){
            event.addDate(parseLocalDateTime(it.next()));
        }

        return event;
    }
}
