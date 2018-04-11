package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.Item;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.daos.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Evgeniy on 22.03.2018.
 */
public abstract class Service {
    private DAO dao;
    private List<Item> listOfItems;

    public Service() {
        listOfItems = new ArrayList<>();
    }

    public Service(DAO<Item> dao) {
        this();
        this.dao = dao;

        dao.getInputs().stream().forEach(i -> this.addItem(i));
    }

    public void addItem(Item item){
        if(item.getId() == 0){
            item.setId((long) listOfItems.size() + 1);
        }

        listOfItems.add(item);
    }

    public void addItems(List<? extends Item> listOfItems){
        listOfItems.stream().forEach(i -> this.addItem(i));
    }

    public void save(){
        dao.saveInputs(listOfItems);
    }

    public void remove(Long id){
        listOfItems.remove(getById(id));
    }

    public Item getById(Long id){
        return listOfItems.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public List<? extends Item> getAll(){
        return listOfItems;
    }
}
