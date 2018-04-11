package com.epam.cources.springcore.tests.parsers;

import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.parsers.UserParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserParserTest {
    private UserParser parser;
    private JSONObject jsonObject;

    @BeforeAll
    void setUp(){
        parser = new UserParser();

        String jsonString = "{\n" +
                "    \"id\": 1,\n" +
                "    \"email\": \"venedey.e@gmail.com\",\n" +
                "    \"role\": \"ADMIN\", \n" +
                "    \"birthday\": {\n" +
                "  \"year\": 1987,\n" +
                "  \"month\": 12,\n" +
                "  \"day\": 30\n" +
                "}\n" +
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
    void testUserParser(){
        Assert.assertNotNull("Instance creation failed.", parser);
    }

    @Test
    void testParseInstance(){
        User user = parser.parseInstance(jsonObject);

        Assert.assertEquals("Method parseInstance() failed: id field parsed " +
                "incorrectly. 1 is expected, got - " + user.getId(), new Long
                (1), user.getId());

        Assert.assertEquals("Method parseInstance() failed: email field " +
                "parsed incorrectly. venedey.e@gmail.com is expected, got - "
                + user.getEmail(), "venedey.e@gmail.com", user.getEmail());

        Assert.assertEquals("Method parseInstance() failed: role field parsed" +
                " incorrectly. ADMIN is expected, got - " + user.getRole(),
                "ADMIN", user.getRole());

        Assert.assertEquals("Method parseInstance() failed: birthday field " +
                "parsed incorrectly. 1987-30-12 is expected, got - " + user
                .getBirthday(), LocalDate.of(1987, 12, 30), user.getBirthday());
    }
}
