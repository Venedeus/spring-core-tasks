package com.epam.cources.springcore.daos;

import com.epam.cources.springcore.parsers.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.List;

public class DAOJsonFileImpl<T> implements DAO {
    private JsonParser parser;
    private String path;

    public DAOJsonFileImpl(JsonParser parser) {
        this.parser = parser;
    }

    @Override
    public List<T> getInputs() {
        return parser.parseArray();
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void saveInputs(List listOfInputs) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            Writer writer = new FileWriter(path);
            writer.write(gson.toJson(listOfInputs));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveInputs(String path, List listOfInputs) {
        saveInputs(path, listOfInputs);
    }
}
