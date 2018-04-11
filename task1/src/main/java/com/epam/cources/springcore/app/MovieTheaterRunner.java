package com.epam.cources.springcore.app;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.Ticket;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.services.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MovieTheaterRunner {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        System.out.println("Movie theater app starts...");

        AppConfig appConfig = AppConfig.getInstance("spring.xml");

        UserService userService = appConfig.getUserService();
        System.out.println(userService.getUserByEmail("venedey1.e@gmail.com"));
        System.out.println(userService.getUserByEmail("venedey@mail.ru"));
        System.out.println(userService.getUserByEmail("venedey@mail.ru"));
        System.out.println(userService.getUserByEmail("venedey.e@gmail.com"));
        System.out.println(userService.getById(2L));
        System.out.println("Tickets of user #1: " + ((User) userService.getById
                (1L)).getTickets());



/*

        Event event = new Event("Rock concert #3");
        event.addDate(LocalDateTime.of(2018, 04, 02, 12, 00));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter file = new FileWriter("events.txt")) {
            file.write(gson.toJson(event));
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

        EventService eventService = appConfig.getEventService();
        System.out.println("Events:");
        System.out.println(eventService.getAll());
        System.out.println("Events by range #1: ");
        eventService.getDateFromRange(LocalDate.now(), LocalDate.of(2018, 04, 01)).forEach(System.out::println);
        System.out.println("Events by range #2: ");
        eventService.getNextEvents(LocalDate.of(2018, 04, 02)).forEach(System.out::println);


        AuditoriumService auditoriumService = appConfig.getAuditoriumService();
        System.out.println("Auditoriums: ");
        System.out.println(auditoriumService.getAll());
        System.out.println(auditoriumService.getById(eventService.getNextEvents(LocalDate.of(2018, 04, 02)).get(0).getId()));

        Ticket ticket = appConfig.getBlankTicket();
        System.out.println(ticket);
        ticket.setUserId(userService.getById(1L).getId());
        ticket.setEventId(eventService.getById(1L).getId());
        ticket.setAirDateTime(LocalDateTime.of(LocalDate.of(2018, 04, 02),
                LocalTime.of(11, 00)));
        ticket.setSeat(10L);
        System.out.println(ticket);

        Validator ticketValidator = appConfig.getValidator();
        System.out.println(ticketValidator.validateTicket(ticket));

        System.out.println("--- BookingService ---");
        BookingService bookingService = appConfig.getBookingService();
        System.out.println(bookingService.getAll().size());
        bookingService.getAll().forEach(System.out::println);

        System.out.println("getPurchasedTicketsForEvent:");
        bookingService.getPurchasedTicketsForEvent(1L, LocalDateTime.of
                (LocalDate.of(2018, 04, 02), LocalTime.of(11, 00))).forEach
                (System.out::println);

        System.out.println("getTicketPrice:");
        List<Long> listOfSeats = new ArrayList<>();
        listOfSeats.add(10L);
        listOfSeats.add(1L);



        System.out.println("Tickets price: " + bookingService.getTicketsPrice(
                (Event) eventService.getById(1L),
                LocalDateTime.of(LocalDate.of(2018, 04, 01), LocalTime.of(11,
                 00)), (User) userService.getById(1L), listOfSeats).floatValue());






        /*    bookingService.purchaseTicket(ticket);
        System.out.println("----------------------");
        bookingService.getAll().forEach(System.out::println);
        bookingService.save();
     */


/*
     Gson gson = new GsonBuilder().setPrettyPrinting().create();

     try (FileWriter file = new FileWriter("tickets.txt")) {
      file.write(gson.toJson(ticket));
     } catch (IOException e) {
      e.printStackTrace();
     }*/


/*
        Auditorium auditorium = new Auditorium("Odeon");
        auditorium.setNumberOfSeats(100);
        auditorium.setVipSeats(Arrays.asList(new Integer[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter file = new FileWriter("auditorium.txt")) {
            file.write(gson.toJson(auditorium));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
   /*     Event event = new Event("Rock concert #11");
        event.addDate(LocalDateTime.of(2018, 04, 02, 12, 00));
        event.setAuditoriumId(1L);
        eventService.addItem(event);
        eventService.save();*/

/*

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(
                    "events.txt"));

            JSONArray jsonArray = (JSONArray) obj;
            Iterator<JSONObject> it = jsonArray.iterator();

            while(it.hasNext())
            {
                JSONObject jsonObject = (JSONObject) it.next();

                String name = (String) jsonObject.get("name");
                Long id = (Long) jsonObject.get("id");
                Map<LocalDate, LocalTime> schedule = (Map) jsonObject.get("schedule");

                System.out.println("Name: " + name);
                System.out.println("Id: " + id);
                System.out.println("Schedule: " + schedule);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
/*
        JsonParser eventsParser = new EventParser("events.txt");
        System.out.println(eventsParser.parseArray());
*/

/*
        DAO dao = new DAOJsonFileImpl(new EventParser("events.txt"));
        System.out.println(dao.getInputs());

        dao = new DAOJsonFileImpl(new UserParser("users.txt"));
        System.out.println(dao.getInputs());
*/




        System.out.println("Movie theater app ends...");
    }
}