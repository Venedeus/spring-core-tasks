package com.epam.cources.springcore.beans;

import java.time.LocalDateTime;

public class Ticket extends Item {
    private enum TicketStatus{
        FREE, BOOKED, PURCHASED;
    }

    private Long eventId;
    private LocalDateTime airDateTime;
    private Long seat;
    private Long userId;
    private TicketStatus ticketStatus;

    public Ticket() {
        this("FREE");
    }

    public Ticket(String ticketStatus) {
        this.ticketStatus = TicketStatus.FREE;

        if(ticketStatus.equalsIgnoreCase(TicketStatus.BOOKED.toString())){
            this.ticketStatus = TicketStatus.BOOKED;
        }

        if(ticketStatus.equalsIgnoreCase(TicketStatus.PURCHASED.toString())){
            this.ticketStatus = TicketStatus.PURCHASED;
        }
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setAirDateTime(LocalDateTime airDateTime) {
        this.airDateTime = airDateTime;
    }

    public void setSeat(Long seat) {
        this.seat = seat;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getAirDateTime() {
        return airDateTime;
    }

    public Long getSeat() {
        return seat;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTicketStatus() {
        return ticketStatus.toString();
    }

    public void bookTicket(){
        this.ticketStatus = TicketStatus.BOOKED;
    }

    public void purchaseTicket(){
        this.ticketStatus = TicketStatus.PURCHASED;
    }

    public boolean isPurchased(){
        boolean isPurchased = false;

        if(ticketStatus.equals(TicketStatus.PURCHASED)){
            isPurchased = true;
        }

        return isPurchased;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "eventId=" + eventId +
                ", airDateTime=" + airDateTime +
                ", seat=" + seat +
                ", userId=" + userId +
                ", ticketStatus=" + ticketStatus +
                '}';
    }
}
