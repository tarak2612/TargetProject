package com.target.retail.service.impl;

import com.target.retail.dao.RetailDAO;
import com.target.retail.model.Price;
import com.target.retail.model.Product;
import com.target.retail.model.ProductDetail;
import com.target.retail.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RetailServiceImpl implements RetailService {

    @Autowired
    RetailDAO dao;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getProductDetailById(Long id) {
        //getting the product name
        ProductDetail response= restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics",ProductDetail.class);
        Map<String,Object> products=response.getProduct();
        Map<String,Object> item= (Map<String,Object>)products.get("item");
        Map<String,Object> productDescription= (Map<String,Object>)item.get("product_description");
        String title= (String)productDescription.get("title");
        //getting pricing detail from mock data
        Price price = dao.getPriceDetailFromApi();
        Product product = new Product();
        product.setId(13860428);
        product.setName(title);
        product.setCurrent_price(price);
        return product;
    }

    @Override
    public Product addProduct(Long id,Product product) {
        Product prod= dao.addProduct(id, product);
        return prod;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws Exception{
        Product prod= dao.updateProduct(id, product);
        return prod;
    }
}
