package com.weine.services;

import com.weine.model.CategoryDto;
import com.weine.model.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to get the products information
 * @author Kaleb
 */
@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<ProductDto> productList = new ArrayList<>();

    public ProductService()
    {
        ProductDto product1 = new ProductDto();
        product1.setId(1);
        product1.setName("Torta de tamal");
        product1.setPrice(BigDecimal.valueOf(36.99));
        product1.setStock(49);
        product1.setImageLink("url1");
        product1.setCategory(new CategoryDto());

        ProductDto product2 = new ProductDto();
        product2.setId(2);
        product2.setName("Hamburguesa");
        product2.setPrice(BigDecimal.valueOf(48));
        product2.setStock(55);
        product2.setImageLink("url2");
        product2.setCategory(new CategoryDto());

        productList.add(product1);
        productList.add(product2);
    }

    public Page<ProductDto> getProducts(Pageable pageable)
    {
        Page<ProductDto> productDtos = new PageImpl<>(productList);
        return  productDtos;
    }
}
