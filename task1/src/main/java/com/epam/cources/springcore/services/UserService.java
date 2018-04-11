package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.Item;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.daos.DAO;

import java.util.List;

public class UserService extends Service {
    public UserService(DAO dao) {
        super(dao);
    }

    public User getUserByEmail(String email){
        return (User) getAll().stream().filter(u -> ((User) u).getEmail().equals
                (email)).findFirst().orElse(null);
    }

    public List<String> getListOfRoles(){
        return User.getListOfRoles();
    }
}
