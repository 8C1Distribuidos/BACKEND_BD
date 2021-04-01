package com.weine.entities;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

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
    @Column(name = "fecha_compra")
    private LocalDateTime dateTime;
    @Column(name = "monto_total")
    private Integer totalPrice;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket")
    private Set<PurchaseItem> purchaseItems = new HashSet<>(1);
}
