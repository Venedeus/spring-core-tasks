package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Validator {
    private EventService eventService;
    private UserService userService;
    private AuditoriumService auditoriumService;

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAuditoriumService(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    public boolean validateTicket(Ticket ticket){
        boolean isValidated = false;
        System.out.println("--->" + eventService);
        System.out.println(ticket.getAirDateTime());
        for(LocalDateTime dateTime: ((Event) eventService.getById(ticket.getEventId())).getSchedule()){
            if(dateTime.isEqual(ticket.getAirDateTime())){
                isValidated = true;
                break;
            }
        }

        return isValidated;
    }

    public boolean checkSeat(Long auditoriumId, Long seatId){
        Auditorium auditorium = (Auditorium) auditoriumService.getAll()
                .stream()
                .filter(i-> i.getId()
                .equals(auditoriumId)).findFirst().orElse(null);

        return auditorium.getVipSeats().contains(seatId);
    }

    public boolean checkUserName(String name){
        return userService.getAll().stream().map(u -> ((User) u).getName()).anyMatch(n -> n.equalsIgnoreCase(name));
    }

    public boolean checkUser(String name, String password){
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        return userService.getAll().stream().anyMatch(u -> ((User) u).getName()
                .equals(name) && ((User) u).getPassword().equals(password));
    }
}
