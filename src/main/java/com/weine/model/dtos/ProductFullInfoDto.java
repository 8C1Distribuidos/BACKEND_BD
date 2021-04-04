package com.weine.model.dtos;

import lombok.*;

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
    Integer price;
    Integer stock;
    CategoryDto category;
}
