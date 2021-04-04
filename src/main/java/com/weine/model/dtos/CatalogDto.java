package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User Dto to show the general info of the <b>catalogs</b>
 * {@link #id} to keep the id of the catalog.<br>
 * {@link #name} to keep the name of the catalog.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDto implements Serializable {
    Integer id;
    String name;
}
