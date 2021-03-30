package com.weine.services;

import com.weine.entities.Product;
import com.weine.mappers.IProductMapper;
import com.weine.model.dtos.CategoryDto;
import com.weine.model.dtos.ProductDto;
import com.weine.repositories.jpa.IProductRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Service to get the products information
 * @author Kaleb
 */
@RequiredArgsConstructor
@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final IProductRep productRep;
    private final IProductMapper productMapper;

    public final static List<ProductDto> PRODUCT_LIST = Arrays.asList(
            new ProductDto(1,"Torta de tamal", "url1", BigDecimal.valueOf(36.99), 49, new CategoryDto(1,"Destilado",null)),
            new ProductDto(2,"Hamburgesa", "url2", BigDecimal.valueOf(48), 55, new CategoryDto(2,"Licor",null))
            );

    /**
     * Function to show the products in pages
     * @param pageable The details of the page
     * @return The Page of products dto
     */
    public Page<ProductDto> getProducts(Pageable pageable)
    {
        Page<Product> products = productRep.findAll(pageable);
        /*Page<ProductDto> productDtos = new PageImpl<>(PRODUCT_LIST);*/
        Page<ProductDto> map = products.map(productMapper::toProductDto);
        return map;
    }
}
