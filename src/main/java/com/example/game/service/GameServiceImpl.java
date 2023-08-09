package com.example.game.service;

import com.example.game.entity.Game;
import com.example.game.exception.GameNotFoundException;
import com.example.game.model.GameRequest;
import com.example.game.model.GameResponse;
import com.example.game.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void createGame(GameRequest gameRequest) {
        gameRepository.save(Game.builder().name(gameRequest.getName()).releaseYear(gameRequest.getReleaseYear())
                .company(gameRequest.getCompany()).category(gameRequest.getCategory()).price(gameRequest.getPrice()).status(gameRequest.getStatus()).build());
    }

    @Override
    public List<GameResponse> getAllGames() {

    List<GameResponse> list = gameRepository.findAll().stream()
            .map(game ->
                    GameResponse.builder()
                            .id(game.getId()).name(game.getName()).releaseYear(game.getReleaseYear()).company(game.getCompany())
                            .category(game.getCategory()).price(game.getPrice()).status(game.getStatus()).build()).collect(Collectors.toList());

        return list;

    }

    @Override
    public GameResponse getGameById(Long id) {

        Game game = gameRepository.findById(id).orElseThrow(()->new GameNotFoundException("Game with id: " + id + " not found"));
        return GameResponse.builder().id(game.getId()).name(game.getName()).releaseYear(game.getReleaseYear()).company(game.getCompany())
                .category(game.getCategory()).price(game.getPrice()).status(game.getStatus()).build();

    }

    @Override
    public void deleteGame(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(()->new GameNotFoundException("Game with id: " + id + " not found"));
        game.setStatus(false);

        gameRepository.save(game);
    }

    @Override
    public String nameTheGameById(Long id) {

        Game game = gameRepository.findById(id).orElseThrow(()->new GameNotFoundException("Game with id: " + id + " not found"));;
        return game.getName();

    }

    @Override
    public void updateGameById(GameRequest gameRequest, Long id) {
        gameRepository.save(Game.builder().id(id).name(gameRequest.getName()).releaseYear(gameRequest.getReleaseYear())
                .company(gameRequest.getCompany()).category(gameRequest.getCategory()).price(gameRequest.getPrice())
                .status(gameRequest.getStatus()).build());
    }

    @Override
    public void updateGameByName(GameRequest gameRequest, String name) {
        Game gameRequest1 = gameRepository.findByName(name).orElseThrow(()->new GameNotFoundException("Game with name: " + name + " not found"));

        gameRepository.save(Game.builder().id(gameRequest1.getId()).name(gameRequest.getName()).releaseYear(gameRequest.getReleaseYear())
                .company(gameRequest.getCompany()).category(gameRequest.getCategory()).price(gameRequest.getPrice())
                .status(gameRequest.getStatus()).build());
    }

}
