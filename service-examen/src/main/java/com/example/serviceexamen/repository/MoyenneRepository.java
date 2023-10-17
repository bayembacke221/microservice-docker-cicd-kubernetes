package com.example.serviceexamen.repository;

import com.example.serviceexamen.model.Moyenne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyenneRepository extends JpaRepository<Moyenne, String> {
    Moyenne findByNumCarte(String numCarte);
}
