package com.weine.services;

import com.weine.model.dtos.CatalogDto;
import com.weine.model.dtos.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to get the products categories information
 * @author Kaleb
 */
@Service
public class CategoryService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<CategoryDto> categoryList = new ArrayList<>();

    public CategoryService(){
        CategoryDto cat1 = new CategoryDto();
        cat1.setId(1);
        cat1.setName("Comida rapida");
        cat1.setCatalog(new CatalogDto(1,"Vinos"));

        CategoryDto cat2 = new CategoryDto();
        cat2.setId(2);
        cat2.setName("Bebidas");
        cat1.setCatalog(new CatalogDto(2,"Destilados"));

        categoryList.add(cat1);
        categoryList.add(cat2);
    }

    public Page<CategoryDto> getCategories(Pageable pageable)
    {
        Page<CategoryDto> categoryDtos = new PageImpl<>(categoryList);
        return  categoryDtos;
    }
}
