package com.culqi.test.controller;

import com.culqi.test.model.ValidateRequest;
import com.culqi.test.service.impl.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @PostMapping("/validate")
    public ResponseEntity<?> validation(@RequestBody ValidateRequest request) {
        return validationService.response(request);
    }
}
