package com.example.demo.services;

import com.example.demo.test.ServiceTest;
import io.specto.hoverfly.junit.core.Hoverfly;
import io.specto.hoverfly.junit5.HoverflyExtension;
import io.specto.hoverfly.junit5.api.HoverflyConfig;
import io.specto.hoverfly.junit5.api.HoverflySimulate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ServiceTest
@ExtendWith(HoverflyExtension.class)
@HoverflySimulate(enableAutoCapture = true, config = @HoverflyConfig(proxyLocalHost = true, plainHttpTunneling = true))
public class ItemsServiceTest {

    @SpyBean
    private ItemsService itemsService;

    @MockBean
    private TicketService ticketService;


    @Test
    void listItems(Hoverfly hoverfly) {
        var list = itemsService.listItems();
        assertThat(list).asList().hasSize(1);
    }

    @Test
    void getItem(Hoverfly hoverfly) {
        var item = itemsService.getItem("1");
        assertThat(item).isNotNull();
    }
}
