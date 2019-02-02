package com.culqi.test.service;

import com.culqi.test.model.BinRequest;
import com.culqi.test.model.BinResponse;
import org.springframework.http.ResponseEntity;

public interface TokenService {

    ResponseEntity<?> response (BinRequest request, String header);
}
