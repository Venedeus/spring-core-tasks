package com.epam.cources.springcore.app;

import com.epam.cources.springcore.beans.Ticket;
import com.epam.cources.springcore.services.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConfig {
    private static AppConfig instance;
    private ConfigurableApplicationContext ctx;
    private String path;
    private UserService userService;
    private EventService eventService;
    private AuditoriumService auditoriumService;
    private BookingService bookingService;
    private Validator validator;

    public static AppConfig getInstance(String path){
        if(instance == null){
            instance = new AppConfig(path);
        }

        return instance;
    }

    private AppConfig(String path) {
        this.path = path;

        this.ctx = new ClassPathXmlApplicationContext(path);

        initServices();
    }

    private void initServices(){
        userService = (UserService) ctx.getBean("userService");
        eventService = (EventService) ctx.getBean("eventService");
        auditoriumService = (AuditoriumService) ctx.getBean("auditoriumService");
        bookingService = (BookingService) ctx.getBean("bookingService");
        validator = (Validator) ctx.getBean("validator");
    }

    public UserService getUserService(){
        return userService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public AuditoriumService getAuditoriumService() {
        return auditoriumService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public Validator getValidator() {
        return validator;
    }

    public Ticket getBlankTicket(){
        return (Ticket) ctx.getBean("blankTicket");
    }

    @Override
    public String toString() {
        return "AppConfig [" +
                "path = '" + path + '\'' +
                ']';
    }
}
