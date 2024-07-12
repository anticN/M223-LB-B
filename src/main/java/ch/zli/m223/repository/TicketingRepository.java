package ch.zli.m223.repository;

import ch.zli.m223.model.Ticket;
import ch.zli.m223.model.impl.TicketImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TicketingRepository extends JpaRepository<TicketImpl, Long> {

    default Ticket create(int halfDaysAmount, LocalDate startDate, String username) {
        var ticket = new TicketImpl(halfDaysAmount, startDate, username);
        return save(ticket);
    }
}
