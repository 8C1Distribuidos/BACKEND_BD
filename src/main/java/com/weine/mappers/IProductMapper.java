package com.weine.mappers;

import com.weine.entities.Catalog;
import com.weine.entities.Category;
import com.weine.entities.Product;
import com.weine.model.dtos.CatalogDto;
import com.weine.model.dtos.CategoryDto;
import com.weine.model.dtos.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IProductMapper {

    @Mapping(target = "category", source = "category")
    @Mapping(target = "category.catalog", source = "category.catalog")
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtoList(List<Product> products);

    CatalogDto toCatalogDto(Catalog catalog);

    CategoryDto toCategoryDto(Category category);
}
