package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Category Dto to show the general info of the products categories
 * @author Kaleb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable{
    Integer id;
    String name;
    CatalogDto catalog;
}
