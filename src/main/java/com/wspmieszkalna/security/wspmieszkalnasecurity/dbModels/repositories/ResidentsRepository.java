package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories;


import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentsRepository extends JpaRepository<Resident, Integer> {
    Optional<Resident> findResidentByLogin(String login);
}
