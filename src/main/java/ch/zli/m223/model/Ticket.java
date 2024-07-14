package ch.zli.m223.model;

import java.time.LocalDate;

public interface Ticket {
    Long getId();
    String getUsername();
    int getHalfDaysAmount();
    LocalDate getStartDate();
    boolean isApproved();
    boolean isDenied();

    void setApproved(boolean isApproved);
    void setDenied(boolean isDenied);
}
