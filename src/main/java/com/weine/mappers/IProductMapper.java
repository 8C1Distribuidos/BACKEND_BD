package com.weine.mappers;

import com.weine.entities.Catalog;
import com.weine.entities.Category;
import com.weine.entities.Product;
import com.weine.model.dtos.CatalogDto;
import com.weine.model.dtos.CategoryDto;
import com.weine.model.dtos.ProductFullInfoDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IProductMapper {
    ProductFullInfoDto toProductFullDto(Product product);

    @InheritInverseConfiguration
    Product toProduct(ProductFullInfoDto productFullInfoDto);

    List<ProductFullInfoDto> toProductDtoList(List<Product> products);

    CatalogDto toCatalogDto(Catalog catalog);


    List<CategoryDto> toCategoryDtoList(List<Category> categories);

    CategoryDto toCategoryDto(Category category);

    @InheritInverseConfiguration
    Category toCategory(CategoryDto category);
}
