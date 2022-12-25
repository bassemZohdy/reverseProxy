package com.example.demo.services;


import com.example.demo.entities.Ticket;
import com.example.demo.repositories.TicketRepository;
import com.example.demo.test.ServiceTest;
import com.example.demo.test.TicketTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ServiceTest
@Import(TicketTestData.class)
public class TicketServiceTest {

    @MockBean
    private TicketRepository repository;
    @Autowired
    private TicketTestData testData;
    @Autowired
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        when(repository.findById(1L)).thenReturn(Optional.of(testData.getTicket()));
        when(repository.save(any(Ticket.class))).thenReturn(testData.getTicket());
        when(repository.findAll()).thenReturn(testData.getTickets());
    }

    @AfterEach
    public void tearDown() {
        reset(repository);
    }

    @Test
    @Order(1)
    void createTicket() {
        var response = ticketService.createTicket(testData.getTicketModel());
        verify(repository).save(any());
        assertEquals("create ticket is the same", testData.getTicketModel(), response);
    }

    @Test
    @Order(2)
    void getTicket() {
        var response = ticketService.getTicket(testData.getTicketModel().getId());
        verify(repository).findById(longThat(id -> id.equals(testData.getTicket().getId())));
        assertEquals("get ticket is the same", Optional.of(testData.getTicketModel()), response);
    }

    @Test
    @Order(3)
    void listTickets() {
        var response = ticketService.listTickets();
        verify(repository).findAll();
        assertEquals("list tickets are the same", testData.getTicketModels(), response);
    }
}
