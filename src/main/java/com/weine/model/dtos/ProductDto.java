package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Product Dto to show the general info of the <b>product</b> as the:
 * {@link #id} to keep the id of the product.<br>
 * {@link #name} to keep the name of the product.<br>
 * This class is the super class of {@link ProductFullInfoDto} and just has to fields to
 * been sent as brief info.
 * @author Kaleb
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
}
