package com.example.game.repository;


import com.example.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long>{
    Optional<Game>findByName(String name);

}
