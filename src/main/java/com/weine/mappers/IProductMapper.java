package com.weine.mappers;

import com.weine.entities.Catalog;
import com.weine.entities.Category;
import com.weine.entities.Product;
import com.weine.model.dtos.CatalogDto;
import com.weine.model.dtos.CategoryDto;
import com.weine.model.dtos.ProductDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IProductMapper {
    ProductDto toProductDto(Product product);

    @InheritInverseConfiguration
    Product toProduct(ProductDto productDto);

    List<ProductDto> toProductDtoList(List<Product> products);

    CatalogDto toCatalogDto(Catalog catalog);


    List<CategoryDto> toCategoryDtoList(List<Category> categories);

    CategoryDto toCategoryDto(Category category);

    @InheritInverseConfiguration
    Category toCategory(CategoryDto category);
}
