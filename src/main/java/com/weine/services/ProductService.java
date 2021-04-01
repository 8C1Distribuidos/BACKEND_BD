package com.weine.services;

import com.weine.entities.Product;
import com.weine.mappers.IProductMapper;
import com.weine.model.criteria.PageProp;
import com.weine.model.criteria.ProductCriteria;
import com.weine.model.dtos.CategoryDto;
import com.weine.model.dtos.ProductDto;
import com.weine.repositories.criteria.ProductCriteriaRep;
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
import java.util.Optional;

/**
 * Service to get the products information
 * @author Kaleb
 */
@RequiredArgsConstructor
@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final IProductRep productRep;
    private final ProductCriteriaRep productCriteriaRep;
    private final IProductMapper productMapper;
    /**
     * Function to show the products in pages
     * @param pageProp The details of the page
     * @return The Page of products dto
     */
    public Page<ProductDto> getProducts(PageProp pageProp, ProductCriteria productCriteria)
    {
        Page<Product> products = productCriteriaRep.findAllWithFilters(pageProp,productCriteria,Product.class);
        /*Page<ProductDto> productDtos = new PageImpl<>(PRODUCT_LIST);*/
        Page<ProductDto> map = products.map(productMapper::toProductDto);
        return map;
    }

    /**
     * Function to find the product by id
     * @param id Id of the Product to search
     * @return The object result
     */
    public ProductDto getProduct(Integer id){
        if(id != null) {
            Optional<Product> pro = productRep.findById(id);
            if (pro.isPresent()) {
                Product product = pro.get();
                return productMapper.toProductDto(product);
            }
        }
        return null;
    }
    /**
     * Function to save the product
     * @param productDto The product dto
     * @return The product dto
     */
   /* public ProductDto saveProduct(ProductDto productDto) {
        if(productDto != null){
            try {
                Product product = productMapper.productDtoToProduct(productDto);
                if(productDto.getProductClassDto() != null) {
                    Integer id = productDto.getProductClassDto().getIdClassification();
                    if (id != null) {
                        Optional<ProductClassification> productClassificationOptional = productClassificationRep.findById(id);
                        if (productClassificationOptional.isPresent()) {
                            ProductClassification productClassification = productClassificationOptional.get();
                            product.setProductclassification(productClassification);
                            product = productRep.save(product);

                            if(productDto.getPictures() != null)
                                for (PictureDto pictureDto : productDto.getPictures())
                                {
                                    savePicture(product,pictureDto);
                                }
                            return productMapper.productToProductDto(product);
                        }
                    }
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }
        return  null;
    }
*/



    /**
     * Function to update the product
     * @param productDto The product to update
     * @return The product updated
     */
    /*public ProductDto updateProduct(ProductDto productDto)
    {
        Integer id = productDto.getIdProduct();
        if(id != null)
        {
            Optional<Product> productO = productRep.findById(id);
            if(productO.isPresent())
            {
                boolean isPriceChanged = false;
                Product product = productO.get();
                //Filling fields
                if(productDto.getProductType() != null)
                    product.setProductType(productDto.getProductType());
                if(productDto.getName() != null)
                    product.setName(productDto.getName());
                if(productDto.getPrivacy() != null)
                    product.setPrivacy(productDto.getPrivacy());
                if(productDto.getMax() != null)
                    product.setMax(productDto.getMax());
                if(productDto.getMin() != null)
                    product.setMin(productDto.getMin());
                if(productDto.getPrice() != null)
                    if(!productDto.getPrice().equals(product.getPrice()))
                    {
                        isPriceChanged = true;
                        product.setPrice(productDto.getPrice());
                    }

                //Verifying product classification
                if(productDto.getProductClassDto() != null)
                {
                    Integer idClass = productDto.getProductClassDto().getIdClassification();
                    if(idClass != null)
                    {
                        Optional<ProductClassification> productClass = productClassificationRep.findById(idClass);
                        //Update the classification of the product
                        if(productClass.isPresent())
                        {
                            product.setProductclassification(productClass.get());
                        }
                    }
                }


                try {
                    product = productRep.save(product);
                    return productMapper.productToProductDto(product);
                }
                catch (Exception e)
                {
                    logger.error(e.getMessage());
                }
            }
        }
        return null;
    }*/

    /**
     * Function to delete a product of the database just if the foreign key constrain allows this
     * @param id The id of the product
     * @return If the row could be eliminated with successful
     */
    public boolean deleteProduct(Integer id)
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
