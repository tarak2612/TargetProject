package com.target.retail.service;

import com.target.retail.dao.RetailDAO;
import com.target.retail.data.MockData;
import com.target.retail.model.Price;
import com.target.retail.model.Product;
import com.target.retail.service.impl.RetailServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailServiceTest {

    @Autowired
    RetailServiceImpl retailService;

    @InjectMocks
    RetailDAO dao;

    @Mock
    MockData mockData;


    @Before
    public void setUp() throws Exception{

        //Mocking for price
        Price price= new Price();
        price.setCurrency_code("USD");
        price.setValue(13.49);
        Mockito.when(dao.getPriceDetailFromApi()).thenReturn(price);

        //Mocking for add product
        Product product= new Product();
        product.setId(12345678L);
        product.setName("This is a added product");
        product.setCurrent_price(price);
        Mockito.when(dao.addProduct(12345678L, product)).thenReturn(product);

        //Mocking for update product
        price.setValue(44.44);
        Mockito.when(dao.updateProduct(12345678L, product)).thenReturn(product);
    }

    @Test
    public void getProductDetailByIdTest(){
        Product product=retailService.getProductDetailById(13860428L);
        Assert.assertNotNull(product);
        Assert.assertEquals(product.getName(),"The Big Lebowski (Blu-ray)");
    }

    @Test
    public void addProductTest(){
        Price price= new Price();
        price.setCurrency_code("USD");
        price.setValue(13.49);
        Product product= new Product();
        product.setId(12345678L);
        product.setName("This is a added product");
        product.setCurrent_price(price);
        Product product1 =retailService.addProduct(12345678L,product);
        Assert.assertNotNull(product1);
    }

    @Test
    public void updateProductTest()throws Exception{
        Price price= new Price();
        price.setCurrency_code("USD");
        price.setValue(44.49);
        Product product= new Product();
        product.setId(12345678L);
        product.setName("This is a added product");
        product.setCurrent_price(price);
        Product product1 =retailService.updateProduct(12345678L,product);
        Assert.assertNotNull(product1);
    }

    @Test(expected = Exception.class)
    public void updateProductWithExceptionTest()throws Exception{
        Price price= new Price();
        price.setCurrency_code("USD");
        price.setValue(44.49);
        Product product= new Product();
        product.setId(12345674L);
        product.setName("This is a added product");
        product.setCurrent_price(price);
        retailService.updateProduct(12345674L,product);
    }
}
