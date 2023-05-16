package com.example.game.service.util;

import com.example.game.controller.response.AccountResponse;
import com.example.game.model.AccountRequest;

public interface AccountService {
    AccountResponse getAccountById(String id);
}
