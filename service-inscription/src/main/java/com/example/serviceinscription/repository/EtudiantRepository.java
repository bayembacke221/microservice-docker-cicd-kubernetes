package com.example.serviceinscription.repository;

import com.example.serviceinscription.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
    Etudiant findByNumCarte(String numeroCarte);
}
