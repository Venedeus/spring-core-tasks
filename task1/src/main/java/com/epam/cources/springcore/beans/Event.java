package com.epam.cources.springcore.beans;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Event extends Item{
    private static enum Rating {
        HIGH, MID, LOW
    }

    private String name;
    private BigDecimal basePrice;
    private Rating rating;
    private Long auditoriumId;
    private List<LocalDateTime> schedule;

    public Event(String name) {
        this.name = name;
        this.schedule = new ArrayList<>();
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public void setRating(String rating) {
        this.rating = Rating.LOW;

        if(rating.equalsIgnoreCase(Rating.MID.toString())){
            this.rating = Rating.MID;
        }

        if(rating.equalsIgnoreCase(Rating.HIGH.toString())){
            this.rating = Rating.HIGH;
        }
    }

    public void setAuditoriumId(Long auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public String getRating() {
        return rating.toString();
    }

    public Long getAuditoriumId() {
        return auditoriumId;
    }

    public List<LocalDateTime> getSchedule() {
        return schedule;
    }

    public void addDate(LocalDateTime dateTime){
        schedule.add(dateTime);
    }

    public static List<String> getListOfRating(){/**
        List<String> listOfRating = new ArrayList<>();
        for(Rating rating: Arrays.asList(Rating.values())){
            listOfRating.add(rating.toString());
        }

        return listOfRating;*/
        return Arrays.asList(Rating.values()).stream().map(r -> r.toString()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", auditoriumId=" + auditoriumId +
                ", schedule=" + schedule +
                '}';
    }
}
