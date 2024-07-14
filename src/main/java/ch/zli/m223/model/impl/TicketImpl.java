package ch.zli.m223.model.impl;

import ch.zli.m223.model.Ticket;
import ch.zli.m223.security.service.impl.JwtServiceImpl;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity(name = "Ticket")
public class TicketImpl implements Ticket {

    @Id
    @GeneratedValue()
    private Long id;

    /*@ManyToOne
    private AppUserImpl user;*/

    @Column(nullable = false)
    private int halfDaysAmount;

    private String username;

    @Column(nullable = false)
    private LocalDate startDate;

    private boolean isApproved;
    private boolean isDenied;

    public TicketImpl(int halfDaysAmount, LocalDate startDate, String username) {
        this.halfDaysAmount = halfDaysAmount;
        this.startDate = startDate;
        this.username = username;
        this.isDenied = false;
        this.isApproved = false;
    }

    protected TicketImpl() {} // For JPA only

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHalfDaysAmount() {
        return halfDaysAmount;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public boolean isApproved() {
        return isApproved;
    }

    @Override
    public boolean isDenied() {
        return isDenied;
    }

    @Override
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public void setDenied(boolean isDenied) {
        this.isDenied = isDenied;
    }
}
