package com.example.game.service;

import com.example.game.entity.Game;
import com.example.game.model.GameRequest;
import com.example.game.model.GameResponse;

import java.util.List;

public interface GameService {
    void createGame(GameRequest gameRequest);
    List<GameResponse> getAllGames();
    GameResponse getGameById(Long id);
    void deleteGame(Long id);
    String nameTheGameById(Long id);
    void updateGameById(GameRequest gameRequest, Long id);
    void updateGameByName(GameRequest gameRequest, String name);

}
