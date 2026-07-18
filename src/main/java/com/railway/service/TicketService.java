package com.railway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.entity.Ticket;
import com.railway.repository.TicketRepository;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // Book Ticket
    public Ticket bookTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Get All Tickets
    @Transactional(readOnly = true)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get Ticket By ID
    @Transactional(readOnly = true)
    public Optional<Ticket> getTicketById(Integer id) {
        return ticketRepository.findById(id);
    }

    // Pagination
    @Transactional(readOnly = true)
    public Page<Ticket> getTicketsByUserId(Integer userId, int page) {

        Pageable pageable = PageRequest.of(page, 2);

        return ticketRepository.findByUserId(userId, pageable);
    }

    // Update Ticket
    public Ticket updateTicket(Integer id, Ticket ticket) {

        Optional<Ticket> optional = ticketRepository.findById(id);

        if (optional.isPresent()) {

            Ticket existing = optional.get();

            existing.setUserId(ticket.getUserId());
            existing.setPassengerName(ticket.getPassengerName());
            existing.setAge(ticket.getAge());
            existing.setGender(ticket.getGender());
            existing.setTrainName(ticket.getTrainName());
            existing.setSource(ticket.getSource());
            existing.setDestination(ticket.getDestination());
            existing.setJourneyDate(ticket.getJourneyDate());
            existing.setTicketPrice(ticket.getTicketPrice());

            return ticketRepository.save(existing);
        }

        return null;
    }

    // Delete Ticket
    public String deleteTicket(Integer id) {

        if (ticketRepository.existsById(id)) {

            ticketRepository.deleteById(id);

            return "Deleted Successfully";
        }

        return "Ticket Not Found";
    }
}