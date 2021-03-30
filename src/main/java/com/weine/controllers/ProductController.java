package com.weine.controllers;

import com.weine.model.dtos.ProductDto;
import com.weine.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to map the http request of the catalog interface
 * @author Kaleb
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private  final ProductService productService;

    @GetMapping()
    public ResponseEntity<Page<ProductDto>> getProducts(
            @PageableDefault(page = 0,size = 5) Pageable pageable
    )
    {
        logger.info("Get products...");
        ResponseEntity<Page<ProductDto>> response = ResponseEntity.ok(this.productService.getProducts(pageable));
        logger.info("Products obtained...");
        return response;
    }
}
