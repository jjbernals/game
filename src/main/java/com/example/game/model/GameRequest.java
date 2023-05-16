package com.example.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameRequest {
    private String name;
    private int releaseYear;
    private String company;
    private String category;
    private Double price;
    private Boolean status;

}
