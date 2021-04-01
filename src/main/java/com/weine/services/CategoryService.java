package com.weine.services;

import com.weine.mappers.IProductMapper;
import com.weine.model.dtos.CatalogDto;
import com.weine.model.dtos.CategoryDto;
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

    public List<CategoryDto> getCategories()
    {
        return productMapper.toCategoryDtoList(categoryRep.findAll());
    }
}
