package com.example.demo.controllers;

import com.example.demo.models.TicketModel;
import com.example.demo.services.TicketService;
import com.example.demo.test.TicketTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebFluxTest(controllers = TicketController.class)
@Import(TicketTestData.class)
public class TicketControllerTest {
    @Autowired
    private WebTestClient webClient;
    @Autowired
    private TicketTestData testData;
    @MockBean
    private TicketService ticketService;

    @Test
    public void createTicket() {
        TicketModel ticket = testData.getTicketModel();
        when(ticketService.createTicket(ticket)).thenReturn(ticket);
        var response = webClient.post().uri("/tickets")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(ticket), TicketModel.class)
                .exchange();
        response.expectStatus().isCreated()
                .expectBody().jsonPath("$.id").isNotEmpty()
                .jsonPath("$.title").isEqualTo(ticket.getTitle())
                .jsonPath("$.description").isEqualTo(ticket.getDescription());
    }

    @Test
    public void getTicket() {
        TicketModel ticket = testData.getTicketModel();
        when(ticketService.getTicket(1L)).thenReturn(Optional.of(ticket));
        var response = webClient.get().uri("/tickets/{id}", 1L)
                .exchange();
        response.expectStatus().isOk()
                .expectBody().jsonPath("$.id").isNotEmpty()
                .jsonPath("$.title").isEqualTo(ticket.getTitle())
                .jsonPath("$.description").isEqualTo(ticket.getDescription());
    }

    @Test
    public void listTickets() {
        List<TicketModel> tickets = testData.getTicketModels();
        when(ticketService.listTickets()).thenReturn(tickets);
        var response = webClient.get().uri("/tickets")
                .exchange();
        response.expectStatus().isOk()
                .expectBodyList(TicketModel.class).hasSize(2).contains(tickets.toArray(TicketModel[]::new));
    }
}