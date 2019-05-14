package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidentsRepository extends JpaRepository<Residents, Integer> {
    Optional<Residents> findByLogin(String login);
}
