package com.example.game.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="game")
@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int releaseYear;
    private String company;
    private String category;
    private Double price;
    private Boolean status;

}
