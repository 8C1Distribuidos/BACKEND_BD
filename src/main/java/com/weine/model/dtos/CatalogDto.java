package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User Dto to show the general info of the catalogs
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDto implements Serializable {
    Integer id;
    String name;
}
