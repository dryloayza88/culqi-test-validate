package com.culqi.test.service.impl;

import com.culqi.test.model.ValidateRequest;
import org.springframework.http.ResponseEntity;

public interface ValidationService {

    ResponseEntity<?> response(ValidateRequest request);
}
