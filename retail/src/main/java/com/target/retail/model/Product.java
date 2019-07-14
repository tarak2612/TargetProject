package com.target.retail.model;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = -9150361094460403434L;

    private long id;
    private String name;
    private Price current_price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Price current_price) {
        this.current_price = current_price;
    }
}
