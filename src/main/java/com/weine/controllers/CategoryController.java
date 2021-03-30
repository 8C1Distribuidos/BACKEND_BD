package com.weine.controllers;

import com.weine.model.dtos.CategoryDto;
import com.weine.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to map the http request of the catalog interface
 * @author Kaleb
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private  final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Page<CategoryDto>> getCatalogs(
            @PageableDefault(page = 0,size = 5) Pageable pageable
    )
    {
        logger.info("Get categories...");
        return ResponseEntity.ok(this.categoryService.getCategories(pageable));
    }
}
