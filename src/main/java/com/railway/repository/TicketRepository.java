package com.railway.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Page<Ticket> findByUserId(Integer userId, Pageable pageable);
}