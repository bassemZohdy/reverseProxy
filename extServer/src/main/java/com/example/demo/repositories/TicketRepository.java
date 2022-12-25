package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Optional<Ticket> findByTitle(String title);
    Optional<Ticket> findByDescriptionContainingIgnoreCase(String descPart);
    
}
