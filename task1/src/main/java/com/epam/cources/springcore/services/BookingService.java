package com.epam.cources.springcore.services;

import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.Ticket;
import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.daos.DAO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService extends Service {
    private static final BigDecimal VIP_KOEFFICIENT = new BigDecimal(2);
    private static final BigDecimal HIGH_RATING_KOEFFICIENT = new BigDecimal(1.2);
    private Validator validator;
    private DiscountService discountService;

    public BookingService(DAO dao) {
        super(dao);
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void bookTicket(Ticket ticket) {
        ticket.bookTicket();
        this.addItem(ticket);
    }

    public void purchaseTicket(Ticket ticket){
        ticket.purchaseTicket();
        this.addItem(ticket);
    }

    public List<Ticket> getPurchasedTicketsForEvent(Long eventId,
                                                    LocalDateTime airDateTime){
        return this.getAll().stream()
                .filter(t -> ((Ticket) t).isPurchased())
                .filter(t -> ((Ticket) t).getAirDateTime().isEqual(airDateTime))
                .map(t -> (Ticket) t)
                .collect(Collectors.toList());
    }

    public BigDecimal getTicketsPrice(Event event, LocalDateTime
            airDateTime, User user, List<Long> seats){
        BigDecimal totalPrice = new BigDecimal(0);

        for(Long seat: seats){
            totalPrice = totalPrice.add(countTicketPrice(event, seat));
        }

        return totalPrice.multiply(new BigDecimal((double)(100 - discountService
                .getDiscount(user, event, airDateTime, seats.size())) / 100));
    }

    private BigDecimal countTicketPrice(Event event, Long seat){
        BigDecimal ticketPrice = event.getBasePrice();

        if(validator.checkSeat(event.getAuditoriumId(), seat)){
            ticketPrice = ticketPrice.multiply(VIP_KOEFFICIENT);
        }

        if(event.getRating().equals("HIGH")){
            ticketPrice = ticketPrice.multiply(HIGH_RATING_KOEFFICIENT);
        }

        return ticketPrice;
    }
}
