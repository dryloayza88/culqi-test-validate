package com.culqi.test.controller;

import com.culqi.test.model.BinRequest;
import com.culqi.test.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/tokens")
    public ResponseEntity<?> sendInformation(@RequestBody BinRequest request,
                                          @RequestHeader(value="Authorization", defaultValue = "") String header) {
        return tokenService.response(request, header);
    }
}
