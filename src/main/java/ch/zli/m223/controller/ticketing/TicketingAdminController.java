package ch.zli.m223.controller.ticketing;

import ch.zli.m223.controller.ticketing.dto.*;
import ch.zli.m223.service.ticketing.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/admin/ticketing")
public class TicketingAdminController {

    @Autowired
    TicketingService ticketingService;

    @PutMapping("/approve/{id}")
    TicketDto acceptTicket(@PathVariable("id") Long id, @RequestBody TicketAcceptDto ticket, Principal principal) {
        return new TicketDto(ticketingService.acceptTicket(id, ticket.isApproved));
    }

    @PutMapping("/deny/{id}")
    TicketDto denyTicket(@PathVariable("id") Long id, @RequestBody TicketDenyDto ticket, Principal principal) {
        return new TicketDto(ticketingService.denyTicket(id, ticket.isDenied));
    }

}