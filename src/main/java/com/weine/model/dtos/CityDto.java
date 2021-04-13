package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * City Dto to wrap the info of the <b>city</b> as the:
 * {@link #id} the id of the city.<br>
 * {@link #name} the name of the city.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    Integer id;
    String name;
}
