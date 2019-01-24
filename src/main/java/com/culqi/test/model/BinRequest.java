package com.culqi.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class BinRequest implements Serializable {

    private String pan;

    private String exp_year;

    private String exp_month;

    public BinRequest() {
    }

}
