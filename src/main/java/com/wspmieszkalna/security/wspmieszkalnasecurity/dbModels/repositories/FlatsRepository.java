package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories;


import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlatsRepository extends JpaRepository<Flat, Integer> {
    Flat findByName(String name);
}
