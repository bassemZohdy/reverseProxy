package com.example.demo.repositories;

import com.example.demo.entities.Ticket;
import com.example.demo.test.TicketTestData;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TicketTestData.class)
@Transactional
public class TicketRepositoryTest {
    @Autowired
    private TicketRepository repository;
    @Autowired
    private TicketTestData testData;

    @Test
    @Order(1)
    void saveAndFindById() {
        var ticket = repository.save(testData.getTicketWithoutId());
        assertThat(ticket).isNotNull();
        assertThat(ticket.getId()).isNotNull();
        assertThat(ticket.getId()).isGreaterThan(0);
        var queryTicket = repository.findById(ticket.getId());
        assertThat(queryTicket).hasValue(ticket);
    }

    @Test
    @Order(2)
    void findByTitle(){
        Ticket ticket = testData.getTicketWithoutId();
        repository.save(ticket);
        var queryTicket = repository.findByTitle(ticket.getTitle());
        assertThat(queryTicket).isNotEmpty();
    }

    @Test
    @Order(3)
    void findByDescriptionContainingIgnoreCase(){
        Ticket ticket = testData.getTicketWithoutId();
        repository.save(ticket);
        var queryTicket = repository.findByDescriptionContainingIgnoreCase(ticket.getDescription().substring(2,5).toLowerCase());
        assertThat(queryTicket).isNotEmpty();
    }

}