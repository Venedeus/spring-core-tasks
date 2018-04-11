package com.epam.cources.springcore.parsers;

import com.epam.cources.springcore.beans.Auditorium;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuditoriumParser extends JsonParser<Auditorium> {
    public AuditoriumParser() {
    }

    public AuditoriumParser(Reader reader) {
        super(reader);
    }

    @Override
    public Auditorium parseInstance(JSONObject jsonObject) {
        Auditorium auditorium = new Auditorium((String) jsonObject.get("name"));
        auditorium.setId((Long) jsonObject.get("id"));
        auditorium.setNumberOfSeats((Long) jsonObject.get("numberOfSeats"));

        JSONArray jsonArray = (JSONArray) jsonObject.get("vipSeats");

        Iterator<Long> it = jsonArray.iterator();
        List<Long> listOfVipSeats = new ArrayList<>();

        while(it.hasNext()){
            listOfVipSeats.add(it.next());
        }

        auditorium.setVipSeats(listOfVipSeats);

        return auditorium;
    }
}
