package com.target.retail.dao;

import com.target.retail.data.MockData;
import com.target.retail.model.Price;
import com.target.retail.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RetailDAO {

    @Autowired
    MockData mockData;

    public Price getPriceDetailFromApi() {
        Price price = mockData.getPriceMockData();
        return price;
    }

    public Product addProduct(Long id, Product product) {
        product.setId(id);
        return mockData.addProductInMockData(product);
    }

    public Product updateProduct(Long id, Product product) throws Exception {
        product.setId(id);
        return mockData.updateProductInMockData(product);
    }
}
