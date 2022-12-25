package com.example.demo.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class TicketModel {
  private Long id;
  private String title;
  private String description;
}
