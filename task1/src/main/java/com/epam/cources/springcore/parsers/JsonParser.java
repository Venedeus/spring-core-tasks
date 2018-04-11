package com.epam.cources.springcore.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class JsonParser<T> {
    private JSONParser parser;
    private Reader reader;

    public JsonParser() {
    }

    public JsonParser(Reader reader) {
        this.reader = reader;
        parser = new JSONParser();
    }

    public List<T> parseArray() {
        List<T> listOfInstances = new ArrayList<>();

        try {
            listOfInstances = parseArray((JSONArray) parser.parse(reader));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listOfInstances;
    }

    private List<T> parseArray(JSONArray jsonArray) {
        List<T> listOfInputs = new ArrayList<>();

        Iterator<JSONObject> it = jsonArray.iterator();

        while (it.hasNext()) {
            T instance = parseInstance(it.next());

            if (instance != null) {
                listOfInputs.add(instance);
            }
        }

        return listOfInputs;
    }

    abstract public T parseInstance(JSONObject jsonObject);

    protected LocalDateTime parseLocalDateTime(JSONObject obj) {
        LocalDate date = parseLocalDate((JSONObject) obj.get("date"));
        LocalTime time = parseLocalTime((JSONObject) obj.get("time"));

        return LocalDateTime.of(date, time);
    }

    protected LocalDate parseLocalDate(JSONObject obj) {
        LocalDate date = LocalDate.of(
                ((Long) obj.get("year")).intValue(),
                ((Long) obj.get("month")).intValue(),
                ((Long) obj.get("day")).intValue());

        return date;
    }

    protected LocalTime parseLocalTime(JSONObject obj) {
        LocalTime time = LocalTime.of(
                ((Long) obj.get("hour")).intValue(),
                ((Long) obj.get("minute")).intValue(),
                ((Long) obj.get("second")).intValue());

        return time;
    }
}
