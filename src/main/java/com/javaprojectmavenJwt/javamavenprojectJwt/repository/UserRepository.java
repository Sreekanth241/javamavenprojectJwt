package com.javaprojectmavenJwt.javamavenprojectJwt.repository;

import com.javaprojectmavenJwt.javamavenprojectJwt.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
   Optional <Users> findByEmail(String email);
}
