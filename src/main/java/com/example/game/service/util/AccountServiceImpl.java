package com.example.game.service.util;

import com.example.game.controller.response.AccountResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AccountServiceImpl implements AccountService{
    @Override
    public AccountResponse getAccountById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        AccountResponse accountResponse = restTemplate.getForObject("http://localhost:8081/account/get/"+id, AccountResponse.class);

        return accountResponse;
    }
}
