package com.culqi.test.controller;

import com.culqi.test.model.BinRequest;
import com.culqi.test.model.BinResponse;
import com.culqi.test.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/tokens")
    public BinResponse sendInformation(@RequestBody BinRequest request) {
        return tokenService.response(request);
    }
}
