package com.target.retail.controller;

import com.target.retail.model.Product;
import com.target.retail.model.ProductDetail;
import com.target.retail.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RetailController {

    @Autowired
    RetailService retailService;

    @GetMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable("id") Long id) {
        return retailService.getProductDetailById(id);
    }

    @PutMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return retailService.addProduct(id, product);
    }

    @PostMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@PathVariable("id") Long id, @RequestBody Product product)throws Exception {
        return retailService.updateProduct(id, product);
    }
}
