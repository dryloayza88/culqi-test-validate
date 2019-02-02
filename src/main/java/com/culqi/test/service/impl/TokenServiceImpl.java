package com.culqi.test.service.impl;

import com.culqi.test.model.BinRequest;
import com.culqi.test.model.BinResponse;
import com.culqi.test.model.ValidationRequest;
import com.culqi.test.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import javax.validation.Validation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String api_url;

    @Value("${url2}")
    private String api_url2;

    @Override
    public BinResponse response(BinRequest request, String header) {
        BinResponse response = new BinResponse();
        ValidationRequest req = new ValidationRequest();
        if(header != null) {
            req.setValidateHeader(header);
        }

        String digits = request.getPan().substring(0,6);
        Map<String, String > params = new HashMap<>();
        params.put("pan", digits);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("headerValue", header);

        HttpEntity<?> httpEntity = new HttpEntity<Object>(body);
        ResponseEntity<ValidationRequest> responseEntity = restTemplate.postForObject(api_url2,req,ResponseEntity.class);
        System.out.println(responseEntity.toString());

        LinkedHashMap lhm = restTemplate.getForObject(api_url, LinkedHashMap.class, params);
        if(lhm != null) {
            response.setBrand(lhm.get("scheme").toString());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = Calendar.getInstance().getTime();
            response.setCreation_dt(df.format(date));
            response.setToken("tkn_live_"+request.getPan()+"-"+request.getExp_year()+"-"+request.getExp_month());

            return response;
        } else {
            return null;
        }

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
