package com.culqi.test.service.impl;

import com.culqi.test.model.ValidateRequest;
import com.culqi.test.model.ValidateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService{


    @Override
    public ResponseEntity<?> response(ValidateRequest request) {
        ValidateResponse validateResponse = new ValidateResponse();
        if(request.getHeader() != null && !request.getHeader().equals("")){
            validateResponse.setValidation("true");
            return ResponseEntity.ok(validateResponse);
        }else {
            validateResponse.setValidation("false");
            return new ResponseEntity(HttpStatus.FORBIDDEN.getReasonPhrase(),HttpStatus.FORBIDDEN);
        }
    }
}
