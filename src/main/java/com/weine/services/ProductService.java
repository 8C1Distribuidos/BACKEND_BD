package com.weine.services;

import com.weine.entities.Product;
import com.weine.mappers.IProductMapper;
import com.weine.model.criteria.PageProp;
import com.weine.model.criteria.ProductCriteria;
import com.weine.model.dtos.ProductDto;
import com.weine.repositories.criteria.ProductCriteriaRep;
import com.weine.repositories.jpa.IProductRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * Service to get the products information
 * @author Kaleb
 * @author Luis
 */
@Transactional
@RequiredArgsConstructor
@Service
public class ProductService implements IServiceApi<ProductDto, ProductCriteria>{
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final IProductRep productRep;
    private final ProductCriteriaRep productCriteriaRep;
    private final IProductMapper productMapper;

    @Override
    public Page<ProductDto> getPage(PageProp pageProp, ProductCriteria productCriteria)
    {
        Page<Product> products = productCriteriaRep.findAllWithFilters(pageProp,productCriteria,Product.class);
        return products.map(productMapper::toProductDto);
    }

    @Override
    public ProductDto find(Integer id){
        if(id != null) {
            Optional<Product> pro = productRep.findById(id);
            if (pro.isPresent()) {
                Product product = pro.get();
                return productMapper.toProductDto(product);
            }
        }
        return null;
    }
    @Override
    public ProductDto save(ProductDto productDto) throws RuntimeException{
        if(productDto != null) {
            productDto.setId(null);//Just to clear the field
            Product product = productMapper.toProduct(productDto);
            Product response = productRep.save(product);
            return productMapper.toProductDto(response);
        }
        return null;
    }
    @Override
    public ProductDto update(ProductDto productDto) throws RuntimeException{
        if(productDto != null) {
            if(find(productDto.getId()) != null) {//Verify the existence of the product
                Product product = productMapper.toProduct(productDto);
                Product response = productRep.save(product);
                return productMapper.toProductDto(response);
            }
        }
        return null;
    }

    /**
     * Function to delete a product of the database just if the foreign key constrain allows this
     * @param id The id of the product
     * @return If the row could be eliminated with successful
     */
    public boolean delete(Integer id)
    {
        if(productRep.findById(id).isPresent())
        {
            try {
                productRep.deleteById(id);
            }catch (Exception e)
            {
                //The user cannot be deleted
                logger.error(e.getMessage());
                return false;
            }

            return true;
        }
        return false;
    }
}
