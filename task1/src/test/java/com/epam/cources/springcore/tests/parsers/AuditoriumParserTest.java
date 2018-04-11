package com.epam.cources.springcore.tests.parsers;

import com.epam.cources.springcore.beans.Auditorium;
import com.epam.cources.springcore.parsers.AuditoriumParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuditoriumParserTest {
    private AuditoriumParser parser;
    private JSONObject jsonObject;

    @BeforeAll
    void setUp(){
        parser = new AuditoriumParser();

        String jsonString = "{ " +
                "\"name\": \"Odeon\"," +
                "\"numberOfSeats\": 100," +
                "\"vipSeats\": [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]," +
                "\"id\": 1" +
                "}";

        jsonObject = new JSONObject();

        try {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAuditoriumParser(){
        Assert.assertNotNull("Instance creation failed.", parser);
    }

    @Test
    void testParseInstance(){
        Auditorium auditorium = parser.parseInstance(jsonObject);

        Assert.assertEquals("Method parseInstance() failed: id field parsed " +
                "incorrectly: 1 is expected, got - " + auditorium.getId(), new Long(1),
                auditorium.getId());

        Assert.assertEquals("Method parseInstance() failed: name field parsed" +
                " incorrectly. Odeon is expected, got - " + auditorium
                        .getName(), "Odeon", auditorium.getName());

        Assert.assertEquals("Method parseInstance() failed: numberOfSeats " +
                "field parsed incorrectly. 100 is expected, got - " +
                auditorium.getNumberOfSeats(), new Long(100), auditorium.getNumberOfSeats());

        Assert.assertEquals("Method parseInstance() failed: vipSeats field " +
                "parsed incorrectly. [10, 20, 30, 40, 50, 60, 70, 80, 90, " +
                "100] is expected, got - " + auditorium.getVipSeats(),
                "[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]",
                auditorium.getVipSeats().toString());
    }
}
