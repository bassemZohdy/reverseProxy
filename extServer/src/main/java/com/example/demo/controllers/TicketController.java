package com.example.demo.controllers;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.example.demo.models.TicketModel;
import com.example.demo.services.TicketService;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
  private final TicketService ticketService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<TicketModel> createTicket(@RequestBody TicketModel ticket) {
    return Mono.just(ticketService.createTicket(ticket));
  }

  @GetMapping("/{id}")
  public Mono<TicketModel> getTicket(@PathVariable Long id) {
    return Mono.justOrEmpty(ticketService.getTicket(id));
  }

  @GetMapping
  public Flux<TicketModel> listTickets() {
    return Flux.fromIterable(ticketService.listTickets());
  }
}
