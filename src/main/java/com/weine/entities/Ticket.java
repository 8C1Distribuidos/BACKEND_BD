package com.weine.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CascadeType.*;

/**
 * Entity to have the field of the table <b>"tickets"</b> as the:</br>
 * {@link #id} to keep the id of the ticket.<br>
 * {@link #idUser} to keep the id of the user related to the ticket.<br>
 * {@link #dateTime} to keep the date and time of the ticket creation.<br>
 * {@link #totalPrice} to keep the amount to pay indicated on the ticket.<br>
 * {@link #purchaseItems} to keep the relation of the purchased products.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "id_usuario", nullable = false)
    private Integer idUser;
    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "monto_total", nullable = false)
    private Integer totalPrice;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
    @Cascade({ALL})
    private Set<PurchaseItem> purchaseItems = new HashSet<>(1);
}
