package com.example.game.controller;

import com.example.game.controller.response.AccountResponse;
import com.example.game.model.AccountRequest;
import com.example.game.model.GameRequest;
import com.example.game.model.GameResponse;
import com.example.game.service.GameServiceImpl;
import com.example.game.service.util.AccountServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameServiceImpl gameServiceImpl;
    private final AccountServiceImpl accountService;

    public GameController(GameServiceImpl gameServiceImpl, AccountServiceImpl accountService) {
        this.gameServiceImpl = gameServiceImpl;
        this.accountService = accountService;
    }

    @GetMapping
    public List<GameResponse> getAllGames(){ return gameServiceImpl.getAllGames(); }

    @GetMapping("/get/{id}")
    public GameResponse getGameById(@PathVariable Long id){ return gameServiceImpl.getGameById(id); }

    @GetMapping("/name/{id}")
    public String getNameTheGameById(@PathVariable Long id){ return gameServiceImpl.nameTheGameById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(@RequestBody GameRequest gameRequest){gameServiceImpl.createGame(gameRequest);}

    @PatchMapping("/updateById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGameById(@RequestBody GameRequest gameRequest, @PathVariable Long id){gameServiceImpl.updateGameById(gameRequest, id);}

    @PatchMapping("/updateByName/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGameByName(@RequestBody GameRequest gameRequest, @PathVariable String name){gameServiceImpl.updateGameByName(gameRequest, name);}

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable Long id){ gameServiceImpl.deleteGame(id); }

    @PostMapping("/user/{id}")
    public AccountResponse getAccountById(@PathVariable String id){
        return accountService.getAccountById(id);
    }
    @PostMapping("linkAGame/{id}")
    public void linkAGameWithAnAccount(@PathVariable Long id, Long idGame) throws JsonProcessingException {
        accountService.linkGameWithAnAccount(idGame, id);
    }
}
