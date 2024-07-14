package ch.zli.m223.service.ticketing.impl;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Ticket;
import ch.zli.m223.repository.TicketingRepository;
import ch.zli.m223.security.service.impl.JwtServiceImpl;
import ch.zli.m223.service.ticketing.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketingServiceImpl implements TicketingService {

    @Autowired
    private TicketingRepository ticketRepository;

    @Autowired
    private JwtServiceImpl jwtService;

    @Override
    public List<Ticket> getAllTicketsByEmail(String username) {
        return new ArrayList<Ticket>(ticketRepository.findAllByUsername(username));
    }

    @Override
    public String getUsername(String token) {
        return jwtService.extractUserName(token);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket createTicket(int halfDaysAmount, LocalDate startDate, String username)  {
        return ticketRepository.create(halfDaysAmount, startDate, username);
    }

    @Override
    public Ticket acceptTicket(Long id, boolean isApproved) {
        var ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setApproved(isApproved);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket denyTicket(Long id, boolean isDenied) {
        var ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setDenied(isDenied);
        return ticketRepository.save(ticket);
    }
}
