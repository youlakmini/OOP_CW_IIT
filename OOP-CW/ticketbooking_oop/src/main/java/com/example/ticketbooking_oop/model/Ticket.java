package com.example.ticketbooking_oop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ticketId;

    @Column(nullable = false)
    private boolean isAvailable;

    public Ticket() {
    }

    public Ticket(String ticketId, boolean isAvailable) {
        this.ticketId = ticketId;
        this.isAvailable = isAvailable;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketId='" + ticketId + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
