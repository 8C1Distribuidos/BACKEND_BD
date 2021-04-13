package com.weine.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CascadeType.ALL;

/**
 * Entity to have the field of the table <b>"tipo_usuarios"</b> as the:</br>
 * {@link #id} to keep the id of the role.<br>
 * {@link #role} to keep the name of the role.<br>
 * {@link #users} to keep the relation of the users.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_usuarios")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "tipo", unique = true, nullable = false, length = 30)
    private String role;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(ALL)
    private Set<User> users;
}
