package com.epam.cources.springcore.tests.parsers;

import com.epam.cources.springcore.parsers.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JsonParserTest {
    private JsonParser parser;
    private JSONArray jsonArray;
    private FileReader reader;

    @BeforeAll
    void setUp() {
        String jsonString = "[" +
                "{\"name\": \"object1\"}," +
                "{\"name\": \"object2\"}" +
                "]";


        try (FileWriter writer = new FileWriter("JsonParserTest.txt")){
            reader = new FileReader("JsonParserTest.txt");
            writer.write(jsonString);

            parser = new JsonParser(reader) {
                @Override
                public Object parseInstance(JSONObject jsonObject) {

                    return jsonObject;
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    void tearDown() {
        try {
            reader.close();
            Files.deleteIfExists(Paths.get("JsonParserTest.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testJsonParser() {
        Assert.assertNotNull("Instance creation failed.", parser);
    }

    @Test
    void testParseArray() {
        List<JSONObject> listOfInstances = parser.parseArray();
        Assert.assertEquals("Method parseArray() failed: 2 items are " +
                        "expected, got - " + listOfInstances.size(), 2,
                listOfInstances.size());
    }
}
