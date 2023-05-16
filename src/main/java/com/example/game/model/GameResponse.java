package com.example.game.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameResponse {
    private Long id;
    private String name;
    private int releaseYear;
    private String company;
    private String category;
    private Double price;
    private Boolean status;

}
