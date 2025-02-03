package com.example.ticketbooking_oop.repository;

import com.example.ticketbooking_oop.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicketId(String ticketId);
}
