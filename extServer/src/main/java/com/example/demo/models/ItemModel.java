package com.example.demo.models;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    private Long id;
    private String name;
}
