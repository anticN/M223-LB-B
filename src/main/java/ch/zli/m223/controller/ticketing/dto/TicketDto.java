package ch.zli.m223.controller.ticketing.dto;

import ch.zli.m223.model.Ticket;

import java.time.LocalDate;
import java.util.Date;

public class TicketDto {
    public long id;
    public String username;
    public int halfDaysAmount;
    public LocalDate startDate;
    public boolean isApproved;
    public boolean isDenied;


    public TicketDto(Ticket ticket) {
        id = ticket.getId();
        halfDaysAmount = ticket.getHalfDaysAmount();
        username = ticket.getUsername();
        startDate = ticket.getStartDate();
        isApproved = ticket.isApproved();
        isDenied = ticket.isDenied();
    }
}
