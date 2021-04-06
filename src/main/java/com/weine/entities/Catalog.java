package com.weine.entities;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"catalogo_productos"</b> as the:</br>
 * {@link #id} to keep the id of the catalog.<br>
 * {@link #name} to keep the name of the catalog.<br>
 * {@link #categories} to keep the relation of the categories.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catalogo_productos")
public class Catalog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", unique = true, nullable = false, length = 10)
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "catalog")
    private List<Category> categories;

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                "name=" + name +
                '}';
    }
}
