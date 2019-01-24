package com.culqi.test;

import com.culqi.test.controller.TokenController;
import com.culqi.test.model.BinRequest;
import com.culqi.test.model.BinResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    TokenController controller;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(controller);
    }

    @Test
    public void validateTokenEndpoint() throws Exception{

        BinRequest request = new BinRequest();
        request.setPan("4444333322221111");
        request.setExp_year("2020");
        request.setExp_month("10");

        BinResponse response = new BinResponse();
        response.setToken("tkn_live_4444333322221111-2020-10");
        response.setBrand("visa");
        response.setCreation_dt("2019-01-23 02:47:08");

        Assert.assertEquals("visa", response.getBrand());
        Assert.assertEquals("tkn_live_4444333322221111-2020-10", response.getToken());
        Assert.assertEquals("2019-01-23 02:47:08", response.getCreation_dt());
        Assert.assertNotNull(controller.sendInformation(request));
        Assert.assertNotNull(restTemplate.getForObject("http://localhost:" + port + "/tokens", BinResponse.class));

    }

}

