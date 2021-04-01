package com.weine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

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
    @Column(name = "fotografia", unique = true, nullable = false, length = 150)
    private String photo;
    @Column(name = "contraseña", nullable = false, length = 50)
    private String password;
    @Column(name = "fecha_nacimiento", nullable = false, length = 50)
    private LocalDate birthDate;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="roles_usuarios", joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_tipo")})
    private Set<Role> roles = new HashSet();
}