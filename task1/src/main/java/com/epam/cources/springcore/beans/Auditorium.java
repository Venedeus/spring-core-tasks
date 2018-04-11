package com.epam.cources.springcore.beans;

import java.util.List;

public class Auditorium extends Item{
    private String name;
    private Long numberOfSeats;
    private List<Long> vipSeats;

    public Auditorium(String name) {
        this.name = name;
    }

    public void setNumberOfSeats(Long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setVipSeats(List<Long> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public String getName() {
        return name;
    }

    public Long getNumberOfSeats() {
        return numberOfSeats;
    }

    public List<Long> getVipSeats() {
        return vipSeats;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vipSeats=" + vipSeats +
                '}';
    }
}
