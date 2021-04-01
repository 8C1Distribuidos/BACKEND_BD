package com.weine.repositories.jpa;

import com.weine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRep extends JpaRepository<User, Integer> {
}
