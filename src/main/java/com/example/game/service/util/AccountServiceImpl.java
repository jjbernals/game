package com.example.game.service.util;

import com.example.game.controller.response.AccountResponse;
import com.example.game.model.AccountRequest;
import com.example.game.repository.GameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AccountServiceImpl implements AccountService{

    private final GameRepository gameRepository;

    public AccountServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public AccountResponse getAccountById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        AccountResponse accountResponse = restTemplate.getForObject("http://localhost:8081/account/get/"+id, AccountResponse.class);

        return accountResponse;
    }

    @Override
    public void linkGameWithAnAccount(Long idGame, Long idUser) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        AccountRequest accountRequest = new AccountRequest();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> http = new HttpEntity<>(objectMapper.writeValueAsString(accountRequest), httpHeaders);

        AccountResponse accountResponse = restTemplate.postForObject("http://localhost:8081/account/post/linkAGameWithAnAccount/"+idUser,http, AccountResponse.class);
    }
}
