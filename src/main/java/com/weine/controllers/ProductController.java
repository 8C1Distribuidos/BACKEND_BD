package com.weine.controllers;

import com.weine.exception.ApiRequestException;
import com.weine.model.criteria.PageProp;
import com.weine.model.criteria.ProductCriteria;
import com.weine.model.dtos.ProductDto;
import com.weine.model.dtos.ProductFullInfoDto;
import com.weine.services.IServiceApi;
import com.weine.services.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to map the http request of the catalog interface
 * @author Kaleb
 * @author Luis
 */
@RestController
@RequestMapping("/products")
public class ProductController extends ControllerApi<ProductFullInfoDto, ProductCriteria, ProductService>{
    private final ProductService productService;
     public ProductController(IServiceApi<ProductFullInfoDto, ProductCriteria> service) {
        super(service);
        productService = (ProductService) service;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @PostMapping("/find-list")
    public ResponseEntity<List<ProductFullInfoDto>> getProducts(@RequestBody List<Integer> ids){
        logger.info("Obtaining "+ getEntityPluralName()+" " + ids +"...");
        List<ProductFullInfoDto> list = productService.getProducts(ids);
        if(list == null)
        {
            logger.info(getEntityName()+ " " + ids + " not found...");
            throw new ApiRequestException("The list request has not been found", HttpStatus.NOT_FOUND);
        }
        logger.info(getEntityPluralName()+" obtained...");
        return ResponseEntity.ok(list);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<ProductFullInfoDto>> getPage(PageProp pageProp, ProductCriteria criteria) {
        return super.getPage(pageProp, criteria);
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<ProductFullInfoDto> findObject(int id) {
        return super.findObject(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<ProductFullInfoDto> saveObject(@RequestBody ProductFullInfoDto requestObject) {
        return super.saveObject(requestObject);
    }

    @PutMapping
    @Override
    public ResponseEntity<ProductFullInfoDto> updateObject(@RequestBody ProductFullInfoDto requestObject) {
        return super.updateObject(requestObject);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteObject(int id) {
        return super.deleteObject(id);
    }

    @Override
    protected String getEntityName() {
        return "Product";
    }

    @Override
    protected String getEntityPluralName() {
        return "Products";
    }
    /*
    @GetMapping()
    public ResponseEntity<Page<ProductDto>> getProducts(
            @RequestParam(required = false) PageProp pageProp, @RequestParam(required = false) ProductCriteria productCriteria
    )
    {
        logger.info("Get products...");
        ResponseEntity<Page<ProductDto>> response = ResponseEntity.ok(this.productService.getPage(pageProp, productCriteria));
        logger.info("Products obtained...");
        return response;
    }

    @GetMapping("/find")
    public ResponseEntity<ProductDto> getProduct(int id)
    {
        logger.info("Find product...");
        ProductDto response = this.productService.find(id);
        if(response == null) {
            logger.info("Product " + id +" not found");
            throw new ApiRequestException("No product " + id + " exist", HttpStatus.NOT_FOUND);
        }
        logger.info("Product found...");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(
            @RequestBody(required = true) ProductDto product
    )
    {
        logger.info("Save product...");
        try{
            ProductDto response = this.productService.save(product);
            if(response == null)
            {
                logger.warn("Product" + product + " not saved");
                throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
            }
            logger.info("Product saved...");
            return ResponseEntity.ok(response);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
        }

    }
     */
}
