package com.weine.model.criteria;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCriteria {
    private String name;
    private Integer stock;
    //To check the stock
    private boolean isStockGreater = true;
    private Integer price;
    private boolean isPriceGreater = true;
}
