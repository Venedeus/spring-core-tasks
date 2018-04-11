package com.epam.cources.springcore.tests.parsers;

import com.epam.cources.springcore.beans.Ticket;
import com.epam.cources.springcore.parsers.TicketParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicketParserTest {
    private TicketParser parser;
    private JSONObject jsonObject;

    @BeforeAll
    void setUp(){
        parser = new TicketParser();

        String jsonString = "{\n" +
                "    \"eventId\": 1,\n" +
                "    \"airDateTime\": {\n" +
                "      \"date\": {\n" +
                "        \"year\": 2018,\n" +
                "        \"month\": 4,\n" +
                "        \"day\": 1\n" +
                "      },\n" +
                "      \"time\": {\n" +
                "        \"hour\": 11,\n" +
                "        \"minute\": 0,\n" +
                "        \"second\": 0,\n" +
                "        \"nano\": 0\n" +
                "      }\n" +
                "    },\n" +
                "    \"seat\": 1,\n" +
                "    \"userId\": 1,\n" +
                "    \"ticketStatus\": \"BOOKED\",\n" +
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
    void testTicketParser(){
        Assert.assertNotNull("Instance creation failed.", parser);
    }

    @Test
    void testParseInstance(){
        Ticket ticket = parser.parseInstance(jsonObject);

        Assert.assertEquals("Method parseInstance() failed: ticketStatus " +
                "field parsed incorrectly. BOOKED is expected, got - " +
                ticket.getTicketStatus(), "BOOKED", ticket.getTicketStatus());

        Assert.assertEquals("Method parseInstance() failed: id field parsed " +
                "incorrectly. 1 is expected, got - " + ticket.getId(), new
                Long(1), ticket.getId());

        Assert.assertEquals("Method parseInstance() failed: eventId field " +
                "parsed incorrectly. 1 is expected, got - " + ticket
                .getEventId(), new Long(1), ticket.getEventId());

        Assert.assertEquals("Method parseInstance() failed: airDateTime field" +
                " parsed incorrectly. 2018-04-01T11:00 is expected, got - " +
                ticket.getAirDateTime(), LocalDateTime.of(LocalDate.of(2018,
                04, 01), LocalTime.of(11, 00)), ticket.getAirDateTime());

        Assert.assertEquals("Method parseInstance() failed: seat field parsed" +
                " incorrectly. 1 is expected, got - " + ticket.getSeat(), new
                Long(1), ticket.getSeat());

        Assert.assertEquals("Method parseInstance() failed: userId field " +
                "parsed incorrectly. 1 is expected, got - " + ticket
                .getUserId(), new Long(1), ticket.getUserId());
    }
}
