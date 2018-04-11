package com.epam.cources.springcore.parsers;

import com.epam.cources.springcore.beans.User;
import org.json.simple.JSONObject;

import java.io.Reader;

public class UserParser extends JsonParser<User> {
    public UserParser() {
    }

    public UserParser(Reader reader) {
        super(reader);
    }

    @Override
    public User parseInstance(JSONObject jsonObject) {
        User user = new User((String) jsonObject.get("role"));
        user.setId((Long)jsonObject.get("id"));
        user.setName((String) jsonObject.get("name"));
        user.setPassword((String) jsonObject.get("password"));
        user.setEmail((String) jsonObject.get("email"));
        user.setTickets((Long) jsonObject.get("tickets"));
        user.setBirthday(parseLocalDate((JSONObject) jsonObject.get
                ("birthday")));

        return user;
    }
}
