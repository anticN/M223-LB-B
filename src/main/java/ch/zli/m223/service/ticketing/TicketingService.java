package ch.zli.m223.service.ticketing;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Ticket;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TicketingService {
    List<Ticket> getAllTicketsByEmail(String username);
    String getUsername(String token);
    Ticket getTicketById(Long id);
    void deleteTicket(Long id);
    Ticket createTicket(int halfDaysAmount, LocalDate startDate, String username);
}
