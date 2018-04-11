package com.epam.cources.springcore.tests.parsers;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.parsers.EventParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventParserTest {
    private EventParser parser;
    private JSONObject jsonObject;

    @BeforeAll
    void setUp(){
        parser = new EventParser();

        String jsonString = "{\n" +
                "    \"name\": \"Rock concert #1\",\n" +
                "    \"auditoriumId\": 1,\n" +
                "    \"rating\": \"HIGH\",\n" +
                "    \"basePrice\": 10,\n" +
                "    \"schedule\": [\n" +
                "      {\n" +
                "        \"date\": {\n" +
                "          \"month\": 4,\n" +
                "          \"year\": 2018,\n" +
                "          \"day\": 1\n" +
                "        },\n" +
                "        \"time\": {\n" +
                "          \"hour\": 11,\n" +
                "          \"nano\": 0,\n" +
                "          \"minute\": 0,\n" +
                "          \"second\": 0\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"id\": 1\n" +
                "  }";

        jsonObject = new JSONObject();

        try {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testEventParser(){
        Assert.assertNotNull("Instance creation failed.", parser);
    }

    @Test
    void testParseInstance(){
        Event event = parser.parseInstance(jsonObject);

        Assert.assertEquals("Method parseInstance() failed: id field parsed " +
                "incorrectly. 1 is expected, got - " + event.getId(), new
                Long(1), event.getId());

        Assert.assertEquals("Method parseInstance() failed: name field parsed" +
                " incorrectly. Rock concert #1 is expected, got - " + event
                .getName(), "Rock concert #1", event.getName());

        Assert.assertEquals("Method parseInstance() failed: auditoriumId " +
                "field parsed incorrectly. 1 is expected, got - " + event
                .getAuditoriumId(), new Long(1), event.getAuditoriumId());

        Assert.assertEquals("Method parseInstance() failed: rating field " +
                "parsed incorrectly. HIGH is expected, got - " + event
                .getRating(), "HIGH", event.getRating());

        Assert.assertEquals("Method parseInstance() failed: basePrice field " +
                "parsed incorrectly. 10 is expected, got - " + event
                .getBasePrice(), new BigDecimal(10), event.getBasePrice());

        Assert.assertEquals("Method parseInstance() failed: schedule field " +
                "parsed incorrectly. [2018-04-01T11:00] is expected, got - "
                + event.getSchedule().get(0), LocalDateTime.of(LocalDate.of
                (2018, 04, 01), LocalTime.of(11, 00)),
                event.getSchedule().get(0));
    }
}
