package com.weine.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CascadeType.ALL;

/**
 * Entity to have the field of the table <b>"municipios"</b> as the:</br>
 * {@link #id} the id of the city.<br>
 * {@link #name} the name of the city.<br>
 * {@link #tickets} the tickets that has this city in the address.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "municipios")
public class City {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "municipio", nullable = false, length = 30)
    private String name;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    @Cascade({ALL})
    private Set<Ticket> tickets;
}
