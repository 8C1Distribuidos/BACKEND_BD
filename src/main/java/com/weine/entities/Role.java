package com.weine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

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
    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="roles")
    private Set<User> users = new HashSet();
}
