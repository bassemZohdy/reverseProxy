package com.example.demo.test;

import com.example.demo.entities.Ticket;
import com.example.demo.models.TicketModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketTestData {
    private static final String THIS_IS_A_TEST_TICKET = "This is a test ticket.";
    private static final String TEST_TICKET = "Test Ticket";

    public Ticket getTicketWithoutId() {
        return Ticket.builder().title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build();
    }

    public TicketModel getTicketModelWithoutId() {
        return TicketModel.builder().title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build();

    }

    public Ticket getTicket() {
        return Ticket.builder().id(1L).title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build();
    }

    public TicketModel getTicketModel() {
        return TicketModel.builder().id(1L).title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build();

    }

    public List<Ticket> getTickets() {
        return List.of(
                Ticket.builder().id(1L).title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build(),
                Ticket.builder().id(2L).title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build());
    }

    public List<TicketModel> getTicketModels() {
        return List.of(
                TicketModel.builder().id(1L).title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build(),
                TicketModel.builder().id(2L).title(TEST_TICKET).description(THIS_IS_A_TEST_TICKET).build());
    }
}
