package com.example.demo.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.TicketMapper;
import com.example.demo.models.TicketModel;
import com.example.demo.repositories.TicketRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

@Service
public class TicketService {
  
  @Autowired
  private TicketRepository repository;
  @Autowired
  private TicketMapper mapper;

  public TicketModel createTicket(TicketModel model) {
    return mapper.map(repository.save(mapper.map(model)));
  }

  public Optional<TicketModel> getTicket(Long id) {
    return repository.findById(id).map(mapper::map);
  }

  public List<TicketModel> listTickets() {
    return repository.findAll().stream().map(mapper::map).collect(Collectors.toList());
  }
}
