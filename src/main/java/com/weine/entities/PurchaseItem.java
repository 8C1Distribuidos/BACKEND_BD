package com.weine.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"producto_por_compra"</b> as the:</br>
 * {@link #id} to keep the id of the purchase item.<br>
 * {@link #amount} to keep the amount paid for the item.<br>
 * {@link #product} to keep the relation of the product.<br>
 * {@link #ticket} to keep the relation of the ticket.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto_por_compra",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_producto", "id_ticket"})})
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id_compra", unique = true, nullable = false)
    private Integer id;
    @Column(name = "cantidad", nullable = false)
    private Integer amount;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket", nullable = false)
    private Ticket ticket;
}
