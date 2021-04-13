package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Category Dto to show the general info of the <b>products categories</b> as the:<br>
 * {@link #id} to keep the id of the category.<br>
 * {@link #name} to keep the name of the category.<br>
 * {@link #catalog} to keep the relation of the catalog.<br>
 *  <b>Is not necessary pass the id in each insert or save of this class, but for updates all the fields is necessary</b>
 *  @author Kaleb
 *  @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable{
    private Integer id;
    private String name;
    private CatalogDto catalog;
}
