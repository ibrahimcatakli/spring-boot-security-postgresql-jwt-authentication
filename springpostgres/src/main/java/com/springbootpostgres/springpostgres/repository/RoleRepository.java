package com.springbootpostgres.springpostgres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpostgres.springpostgres.model.ERole;
import com.springbootpostgres.springpostgres.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
