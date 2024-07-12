package ch.zli.m223.controller.ticketing;

import ch.zli.m223.controller.ticketing.dto.TicketDto;
import ch.zli.m223.controller.ticketing.dto.TicketInputDto;
import ch.zli.m223.service.ticketing.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/member/ticketing")
public class TicketingMemberController {

    @Autowired
    TicketingService ticketingService;

    @PostMapping("")
    TicketDto createTicket(@RequestBody TicketInputDto ticket, Principal principal) {
        return new TicketDto(ticketingService.createTicket(ticket.halfDaysAmount, ticket.startDate, principal.getName()));
    }

    @GetMapping("/{id}")
    public TicketDto getTicketById(@PathVariable("id") Long id) {
        return new TicketDto(ticketingService.getTicketById(id));
    }

    @GetMapping("")
    List<TicketDto> getTickets(Principal principal) {
        return ticketingService.getAllTicketsByEmail(principal.getName()).stream()
                .map((ticket) -> new TicketDto(ticket))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable("id") Long id) {
        ticketingService.deleteTicket(id);
    }
}
