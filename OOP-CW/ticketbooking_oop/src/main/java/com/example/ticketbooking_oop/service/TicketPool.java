package com.example.ticketbooking_oop.service;

import com.example.ticketbooking_oop.model.Ticket;
import com.example.ticketbooking_oop.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketPool {
    private final TicketRepository ticketRepository;

    public TicketPool(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Add a ticket to the pool
    public synchronized void addTicket(String ticketId) {
        if (ticketRepository.findByTicketId(ticketId).isPresent()) {
            throw new IllegalArgumentException("Ticket with ID " + ticketId + " already exists.");
        }
        Ticket ticket = new Ticket(ticketId, true);
        ticketRepository.save(ticket);
        System.out.println("Added ticket to DB: " + ticketId);
    }

    // Purchase a ticket from the pool
    public synchronized Optional<Ticket> removeTicket() {
        Optional<Ticket> ticket = ticketRepository.findAll().stream()
                .filter(Ticket::isAvailable)
                .findFirst();

        ticket.ifPresent(t -> {
            t.setAvailable(false);
            ticketRepository.save(t);
            System.out.println("Ticket purchased: " + t.getTicketId());
        });

        return ticket;
    }

    // Retrieve all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get the count of available tickets
    public int getCurrentSize() {
        return (int) ticketRepository.findAll().stream()
                .filter(Ticket::isAvailable)
                .count();
    }
}
