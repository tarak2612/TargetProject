package com.target.retail.service;

import com.target.retail.model.Product;

public interface RetailService {

    Product getProductDetailById(Long id);

    Product addProduct(Long id ,Product product);

    Product updateProduct(Long id ,Product product) throws Exception;

}
