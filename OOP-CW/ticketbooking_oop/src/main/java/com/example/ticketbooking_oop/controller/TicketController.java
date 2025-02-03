package com.example.ticketbooking_oop.controller;

import com.example.ticketbooking_oop.model.Ticket;
import com.example.ticketbooking_oop.service.TicketPool;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketPool ticketPool;


    public TicketController(TicketPool ticketPool) {
        this.ticketPool = ticketPool;

    }

    // Add a ticket to the pool
    @PostMapping("/add")
    public ResponseEntity<String> addTicket(@RequestBody String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Ticket ID cannot be null or empty.");
        }
        try {
            ticketPool.addTicket(ticketId.trim());
            return ResponseEntity.ok("Ticket added successfully: " + ticketId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding ticket: " + e.getMessage());
        }
    }

    // Purchase a ticket
    @GetMapping("/buy")
    public ResponseEntity<String> buyTicket() {
        try {
            return ticketPool.removeTicket()
                    .map(ticket -> ResponseEntity.ok("Ticket purchased: " + ticket.getTicketId()))
                    .orElse(ResponseEntity.badRequest().body("No available tickets to purchase"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error during ticket purchase: " + e.getMessage());
        }
    }

    // Get all tickets
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketPool.getAllTickets());
    }

    // Get the number of available tickets
    @GetMapping("/count")
    public ResponseEntity<Integer> getAvailableTicketsCount() {
        return ResponseEntity.ok(ticketPool.getCurrentSize());
    }

}
