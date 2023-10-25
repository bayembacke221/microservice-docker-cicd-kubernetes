package com.example.serviceinscription.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class EtudiantTest {

    @Test
     void testGetterAndSetters() {
        // GIVEN
        Etudiant etudiant = new Etudiant();

        // WHEN
        etudiant.setNumCarte("123456789");
        etudiant.setPrenom("John");
        etudiant.setNom("Doe");
        etudiant.setClasse("T3A");

        // THEN
        assertEquals("123456789", etudiant.getNumCarte());
        assertEquals("John", etudiant.getPrenom());
        assertEquals("Doe", etudiant.getNom());
        assertEquals("T3A", etudiant.getClasse());
    }

    @Test
     void testEquals() {
        // GIVEN
        Etudiant etudiant1 = new Etudiant("123456789", "John", "Doe", "T3A");
        Etudiant etudiant2 = new Etudiant("123456789", "John", "Doe", "T3A");

        // THEN
        assertEquals(etudiant1, etudiant2);
    }

    @Test
     void testHashCode() {
        // GIVEN
        Etudiant etudiant1 = new Etudiant("123456789", "John", "Doe", "T3A");
        Etudiant etudiant2 = new Etudiant("123456789", "John", "Doe", "T3A");

        // THEN
        assertEquals(etudiant1.hashCode(), etudiant2.hashCode());
    }

}
