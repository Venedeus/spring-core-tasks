package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.Auditorium;
import com.epam.cources.springcore.beans.Item;
import com.epam.cources.springcore.daos.DAO;

import java.util.List;
import java.util.stream.Collectors;

public class AuditoriumService extends Service {
    public AuditoriumService(DAO dao) {
        super(dao);
    }

    public Auditorium getByName(String name){
        return (Auditorium) getAll().stream().filter(a -> ((Auditorium) a).getName().equals(name)).findFirst().orElse(null);
    }

    public List<String> getAllByNames(){
        return getAll().stream().map(a -> ((Auditorium) a).getName()).collect
                (Collectors.toList());
    }
}
