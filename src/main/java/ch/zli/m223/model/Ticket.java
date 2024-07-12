package ch.zli.m223.model;

import org.apache.catalina.User;

import java.time.LocalDate;

public interface Ticket {
    Long getId();
    String getUsername();
    int getHalfDaysAmount();
    LocalDate getStartDate();
    boolean isApproved();
    boolean isDenied();

}
