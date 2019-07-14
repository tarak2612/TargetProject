package com.target.retail.data;

import com.target.retail.model.Price;
import com.target.retail.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MockData {
    Map<Long,Product> productData;
    {
        productData = new HashMap<>();
    }
    public Price getPriceMockData()
    {
        Price price= new Price();
        price.setCurrency_code("USD");
        price.setValue(13.49);
        return price;
    }

    public Product addProductInMockData(Product product){
       productData.put(product.getId(),product);
        return product;
    }

    public Product updateProductInMockData(Product product) throws Exception{
        Product availableProduct=productData.get(product.getId());
       if(!Optional.ofNullable(availableProduct).isPresent()){
            throw new Exception("Product is not avalible");
       }
        productData.put(availableProduct.getId(),product);
        return product;
    }
}
