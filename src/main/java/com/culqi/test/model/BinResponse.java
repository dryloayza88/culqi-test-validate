package com.culqi.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BinResponse implements Serializable {

    private String token;

    private String brand;

    private String creation_dt;

    public BinResponse() {
    }

}
