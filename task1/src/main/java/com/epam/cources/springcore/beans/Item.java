package com.epam.cources.springcore.beans;

/**
 * Created by Evgeniy on 22.03.2018.
 */
public abstract class Item {
    private Long id;

    public Item(){
        this.id = 0L;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}