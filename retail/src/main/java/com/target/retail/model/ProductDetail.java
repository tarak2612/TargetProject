package com.target.retail.model;

import java.io.Serializable;
import java.util.Map;

public class ProductDetail implements Serializable {

    private static final long serialVersionUID = -9150361094460403434L;

    private Map<String,Object> product;

    public Map<String, Object> getProduct() {
        return product;
    }

    public void setProduct(Map<String, Object> product) {
        this.product = product;
    }
}
