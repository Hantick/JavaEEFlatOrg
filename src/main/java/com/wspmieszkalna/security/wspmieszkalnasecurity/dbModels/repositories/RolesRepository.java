package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(String role);
}
