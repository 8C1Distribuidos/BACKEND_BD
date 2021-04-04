package com.weine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"productos"</b> as the:</br>
 * {@link #id} to keep the id of the product.<br>
 * {@link #name} to keep the name of the product.<br>
 * {@link #imageLink} to keep the image of the product as a link.<br>
 * {@link #stock} to keep the stock of the product.<br>
 * {@link #price} to keep the price of the product.<br>
 * {@link #category} to keep the relation of the category.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", unique = true, nullable = false, length = 50)
    private String name;
    @Column(name = "link_imagen", nullable = false, length = 150)
    private String imageLink;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "precio", nullable = false)
    private Integer price;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
