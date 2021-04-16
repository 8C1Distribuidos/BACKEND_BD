package com.weine.repositories.jpa;

import com.weine.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRep extends JpaRepository<Role, Integer> {
}
