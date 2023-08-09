package com.example.game.service.util;

import com.example.game.controller.response.AccountResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AccountService {
    AccountResponse getAccountById(String id);
    void linkGameWithAnAccount(Long idGame, Long idUser) throws JsonProcessingException;

}
