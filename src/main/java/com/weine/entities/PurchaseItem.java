package com.weine.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto_por_compra")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id_compra", unique = true, nullable = false)
    private Integer id;
    @Column(name = "cantidad", nullable = false)
    private Integer amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket", nullable = false)
    private Ticket ticket;
}
