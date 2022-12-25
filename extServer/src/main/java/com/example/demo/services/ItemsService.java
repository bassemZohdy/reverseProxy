package com.example.demo.services;

import com.example.demo.models.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ItemsService {
    @Autowired
    @Qualifier("webClient3000")
    private WebClient webClient;

    List<ItemModel> listItems(){
        return webClient.get().uri("/items").retrieve().bodyToFlux(ItemModel.class).collectList().block();
    }

    ItemModel getItem(String id){
        return webClient.get().uri(ub->ub.path("/items/{id}").build(id)).retrieve().bodyToMono(ItemModel.class).block();
    }
}
