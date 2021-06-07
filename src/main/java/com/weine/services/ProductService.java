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

import java.util.List;
import java.util.Optional;

/**
 * Service to get the products information
 * @author Kaleb
 * @author Luis
 */
@Transactional
@RequiredArgsConstructor
@Service
public class  ProductService implements IServiceApi<ProductFullInfoDto, ProductCriteria>{
    private final IProductRep productRep;
    private final ProductCriteriaRep productCriteriaRep;
    private final IProductMapper productMapper;

    @Override
    public Page<ProductFullInfoDto> getPage(PageProp pageProp, ProductCriteria productCriteria)
    {
        Page<Product> products = productCriteriaRep.findAllWithFilters(pageProp,productCriteria,Product.class);
        return products.map(productMapper::toProductFullDto);
    }

    public Product getProduct(Integer id){
        if(id != null) {
            Optional<Product> pro = productRep.findById(id);
            if (pro.isPresent()) {
                return pro.get();
            }
        }
        return null;
    }

    @Override
    public ProductFullInfoDto find(Integer id){
        return productMapper.toProductFullDto(getProduct(id));
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
        Product product = getProduct(id);
        if(product != null)
        {
            if(product.getItems() != null && product.getItems().isEmpty()) {
                //If this product doesn't have any relation can be deleted
                productRep.deleteById(id);
            }
            else{//In the case of this product exist in one or more relations
                product.setDeleted(true);
                productRep.save(product);
            }
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

    public List<ProductFullInfoDto> getProducts(List<Integer> ids) {
        if(ids != null) {
            return productMapper.toProductDtoList(productRep.findByIdIn(ids));
        }
        else{
            return null;
        }
    }
}
