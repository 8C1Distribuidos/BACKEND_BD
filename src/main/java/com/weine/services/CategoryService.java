package com.weine.services;

import com.weine.entities.Category;
import com.weine.mappers.IProductMapper;
import com.weine.model.dtos.CategoryDto;
import com.weine.repositories.jpa.ICategoryRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service to get the products categories information
 * @author Kaleb
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class CategoryService implements IServiceApi<CategoryDto, Object>{
    private final ICategoryRep categoryRep;
    private final IProductMapper productMapper;
    @Override
    public List<CategoryDto> getObjects()
    {
        return productMapper.toCategoryDtoList(categoryRep.findAll());
    }

    @Override
    public CategoryDto find(Integer id) {
        if(id != null) {
            Optional<Category> pro = categoryRep.findById(id);
            if (pro.isPresent()) {
                Category category = pro.get();
                return productMapper.toCategoryDto(category);
            }
        }
        return null;
    }

    @Override
    public CategoryDto save(CategoryDto request) {
        if(request != null) {
            request.setId(null);//Just to clear the field
            Category category = productMapper.toCategory(request);
            Category response = categoryRep.save(category);
            return productMapper.toCategoryDto(response);
        }
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto request) {
        if(request != null) {
            if(find(request.getId()) != null) {
                request.setId(null);//Just to clear the field
                Category category = productMapper.toCategory(request);
                Category response = categoryRep.save(category);
                return productMapper.toCategoryDto(response);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id)  {
        if(id != null) {
            categoryRep.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public boolean checkExistence(Integer id) {
        if(id != null)
            return categoryRep.findById(id).isPresent();
        return false;
    }
}
