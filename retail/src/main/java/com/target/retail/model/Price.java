package com.target.retail.model;

import java.io.Serializable;

public class Price implements Serializable {

    private static final long serialVersionUID = -9150361094460403430L;

    private String currency_code;
    private double value;

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
