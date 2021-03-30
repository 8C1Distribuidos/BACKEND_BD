package com.weine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Product Dto to show the general info of the products
 * @author Kaleb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable{
    Integer id;
    String name;
    String imageLink;
    BigDecimal price;
    Integer stock;
    CategoryDto category;
}
