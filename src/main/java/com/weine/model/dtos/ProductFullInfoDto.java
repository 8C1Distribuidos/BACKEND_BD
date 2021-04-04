package com.weine.model.dtos;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Product Dto to show all the info of the products
 * @author Kaleb
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFullInfoDto extends ProductDto{
    String imageLink;
    BigDecimal price;
    Integer stock;
    CategoryDto category;
}
