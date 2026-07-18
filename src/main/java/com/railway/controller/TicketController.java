package com.railway.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.railway.entity.Ticket;
import com.railway.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    // 1. Book Ticket

    @PostMapping
    public Ticket bookTicket(
            @RequestBody Ticket ticket) {

        return ticketService.bookTicket(ticket);
    }


    // 2. Get All Tickets

    @GetMapping
    public List<Ticket> getAllTickets() {

        return ticketService.getAllTickets();
    }


    // 3. Get All Tickets By User ID

    @GetMapping("/user/{userId}")
    public Page<Ticket> getTicketsByUserId(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "0") int page) {

        return ticketService.getTicketsByUserId(userId, page);
    }

    // 4. Get Ticket By Ticket ID

    @GetMapping("/{id}")
    public Optional<Ticket> getTicketById(
            @PathVariable Integer id) {

        return ticketService.getTicketById(id);
    }


    // 5. Update Ticket

    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable Integer id,
            @RequestBody Ticket ticket) {

        return ticketService.updateTicket(id, ticket);
    }


    // 6. Delete Ticket

    @DeleteMapping("/{id}")
    public String deleteTicket(
            @PathVariable Integer id) {

        return ticketService.deleteTicket(id);
    }
}