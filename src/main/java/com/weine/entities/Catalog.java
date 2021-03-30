package com.weine.entities;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "catalogo_productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", unique = true, nullable = false, length = 10)
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "catalog")
    private List<Category> categories;
}
