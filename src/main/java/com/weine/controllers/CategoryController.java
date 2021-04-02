package com.weine.controllers;

import com.weine.exception.ApiRequestException;
import com.weine.model.dtos.BankAccountDto;
import com.weine.model.dtos.CategoryDto;
import com.weine.services.CategoryService;
import com.weine.services.IServiceApi;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to map the http request of the catalog interface
 * @author Kaleb
 */
@RestController
@RequestMapping("/categories")
public class CategoryController extends ControllerApi<CategoryDto, Object, CategoryService>{
    public CategoryController(IServiceApi<CategoryDto, Object> service) {
        super(service);
        logger = LoggerFactory.getLogger(CategoryController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CategoryDto>> getObjects() {
        return super.getObjects();
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<CategoryDto> findObject(int id) {
        return super.findObject(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<CategoryDto> saveObject(@RequestParam CategoryDto requestObject) {
        return super.saveObject(requestObject);
    }

    @PutMapping
    @Override
    public ResponseEntity<CategoryDto> updateObject(@RequestParam CategoryDto requestObject) {
        return super.updateObject(requestObject);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteObject(int id) {
        return super.deleteObject(id);
    }

    @Override
    protected String getEntityName() {
        return "Category";
    }

    @Override
    protected String getEntityPluralName() {
        return "Categories";
    }
}
