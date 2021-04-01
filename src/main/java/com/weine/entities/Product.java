package com.weine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

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
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
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
