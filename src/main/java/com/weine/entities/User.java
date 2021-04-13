package com.weine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"usuarios"</b> as the:</br>
 * {@link #id} to keep the id of the user.<br>
 * {@link #firstName} to keep the first name of the user.<br>
 * {@link #maternalName} to keep the maternal name of the user.<br>
 * {@link #paternalName} to keep the paternal name of the user.<br>
 * {@link #email} to keep the email address of the user.<br>
 * {@link #photo} to keep photo of the user.<br>
 * {@link #password} to keep the password of the user.<br>
 * {@link #role} to keep the relation of the user role.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 30)
    private String firstName;
    @Column(name = "apellido_materno", nullable = false, length = 20)
    private String maternalName;
    @Column(name = "apellido_paterno", nullable = false, length = 20)
    private String paternalName;
    @Column(name = "correo_electronico", nullable = false, length = 30)
    private String email;
    @Column(name = "fotografia", nullable = false, length = 150)
    private String photo;
    @Column(name = "contraseña", nullable = false, length = 50)
    private String password;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", nullable = false)
    private Role role;
}