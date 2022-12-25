package com.example.demo.mappers;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Ticket;
import com.example.demo.models.TicketModel;

@Component
public class TicketMapper {

    public TicketModel map(Ticket source) {
        return TicketModel.builder()
        .id(source.getId())
        .title(source.getTitle())
        .description(source.getDescription())
        .build();
    }

    public Ticket map(TicketModel source) {
        return Ticket.builder()
        .id(source.getId())
        .title(source.getTitle())
        .description(source.getDescription())
        .build();
    }
}
