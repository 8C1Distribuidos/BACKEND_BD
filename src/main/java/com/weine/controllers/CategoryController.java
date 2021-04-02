package com.weine.controllers;

import com.weine.exception.ApiRequestException;
import com.weine.model.dtos.BankAccountDto;
import com.weine.model.dtos.CategoryDto;
import com.weine.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to map the http request of the catalog interface
 * @author Kaleb
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private  final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getCatalogs()
    {
        logger.info("Get categories...");
        ResponseEntity<List<CategoryDto>> mappers = ResponseEntity.ok(this.categoryService.getCategories());
        logger.info("Categories obtained...");
        return mappers;
    }

    @GetMapping("/find")
    public ResponseEntity<CategoryDto> getCategory(int id) {
        logger.info("Find category...");
        CategoryDto result = this.categoryService.getCategory(id);
        if (result == null) {
            logger.info("Category " + id + " not found");
            throw new ApiRequestException("No category id" + id + " exist", HttpStatus.NOT_FOUND);
        }
        logger.info("Account found...");
        return ResponseEntity.ok(result);

    }
}
