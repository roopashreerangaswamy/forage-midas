package com.jpmc.midascore.controller;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRepository;
import com.jpmc.midascore.foundation.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Balance getBalance(@RequestParam("userId") long userId) {
        UserRecord user = userRepository.findById(userId).orElse(null);
        float balanceAmount = (user != null) ? user.getBalance() : 0.0f;
        return new Balance(balanceAmount);
    }

}
