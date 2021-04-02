package com.weine.services;

import com.weine.entities.Category;
import com.weine.entities.Product;
import com.weine.mappers.IProductMapper;
import com.weine.model.dtos.CatalogDto;
import com.weine.model.dtos.CategoryDto;
import com.weine.model.dtos.ProductDto;
import com.weine.repositories.jpa.ICategoryRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service to get the products categories information
 * @author Kaleb
 */
@RequiredArgsConstructor
@Service
public class CategoryService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final ICategoryRep categoryRep;
    private final IProductMapper productMapper;
    /**
     * Function to get the list of categories
     * @return The categories
     */
    public List<CategoryDto> getCategories()
    {
        return productMapper.toCategoryDtoList(categoryRep.findAll());
    }

    /**
     * Function to find the category by id
     * @param id Id of the Category to search
     * @return The object result
     */
    public CategoryDto getCategory(Integer id)
    {
        if(id != null) {
            Optional<Category> pro = categoryRep.findById(id);
            if (pro.isPresent()) {
                Category category = pro.get();
                return productMapper.toCategoryDto(category);
            }
        }
        return null;
    }
}
