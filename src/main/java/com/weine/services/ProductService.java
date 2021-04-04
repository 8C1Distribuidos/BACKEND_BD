package com.weine.services;

import com.weine.entities.Product;
import com.weine.mappers.IProductMapper;
import com.weine.model.criteria.PageProp;
import com.weine.model.criteria.ProductCriteria;
import com.weine.model.dtos.ProductFullInfoDto;
import com.weine.repositories.criteria.ProductCriteriaRep;
import com.weine.repositories.jpa.IProductRep;
import lombok.RequiredArgsConstructor;
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
public class ProductService implements IServiceApi<ProductFullInfoDto, ProductCriteria>{
    private final IProductRep productRep;
    private final ProductCriteriaRep productCriteriaRep;
    private final IProductMapper productMapper;

    @Override
    public Page<ProductFullInfoDto> getPage(PageProp pageProp, ProductCriteria productCriteria)
    {
        Page<Product> products = productCriteriaRep.findAllWithFilters(pageProp,productCriteria,Product.class);
        return products.map(productMapper::toProductFullDto);
    }

    @Override
    public ProductFullInfoDto find(Integer id){
        if(id != null) {
            Optional<Product> pro = productRep.findById(id);
            if (pro.isPresent()) {
                Product product = pro.get();
                return productMapper.toProductFullDto(product);
            }
        }
        return null;
    }
    @Override
    public ProductFullInfoDto save(ProductFullInfoDto productFullInfoDto) throws RuntimeException{
        if(productFullInfoDto != null) {
            productFullInfoDto.setId(null);//Just to clear the field
            Product product = productMapper.toProduct(productFullInfoDto);
            Product response = productRep.save(product);
            return productMapper.toProductFullDto(response);
        }
        return null;
    }
    @Override
    public ProductFullInfoDto update(ProductFullInfoDto productFullInfoDto) throws RuntimeException{
        if(productFullInfoDto != null) {
            if(find(productFullInfoDto.getId()) != null) {//Verify the existence of the product
                Product product = productMapper.toProduct(productFullInfoDto);
                Product response = productRep.save(product);
                return productMapper.toProductFullDto(response);
            }
        }
        return null;
    }
    @Override
    public boolean delete(Integer id)
    {
        if(id != null)
        {
            productRep.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public boolean checkExistence(Integer id) {
        if(id != null)
            return productRep.findById(id).isPresent();
        return false;
    }
}
