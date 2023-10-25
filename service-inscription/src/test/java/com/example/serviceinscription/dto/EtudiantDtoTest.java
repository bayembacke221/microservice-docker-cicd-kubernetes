package com.example.serviceinscription.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class EtudiantDtoTest {

    @Test
     void testConstructorAndGetters() {
        EtudiantDto etudiantDto = new EtudiantDto("12345", "John", "Doe", "Math");

        assertEquals("12345", etudiantDto.numCarte());
        assertEquals("John", etudiantDto.prenom());
        assertEquals("Doe", etudiantDto.nom());
        assertEquals("Math", etudiantDto.classe());
    }

    @Test
     void testEqualsAndHashCode() {
        EtudiantDto etudiantDto1 = new EtudiantDto("12345", "John", "Doe", "Math");
        EtudiantDto etudiantDto2 = new EtudiantDto("12345", "John", "Doe", "Math");
        EtudiantDto etudiantDto3 = new EtudiantDto("54321", "Jane", "Smith", "Physics");

        assertEquals(etudiantDto1, etudiantDto2);
        assertNotEquals(etudiantDto1, etudiantDto3);
        assertEquals(etudiantDto1.hashCode(), etudiantDto2.hashCode());
    }

    @Test
     void testToString() {
        EtudiantDto etudiantDto = new EtudiantDto("12345", "John", "Doe", "Math");
        String expectedToString = "EtudiantDto[numCarte=12345, prenom=John, nom=Doe, classe=Math]";

        assertEquals(expectedToString, etudiantDto.toString());
    }
}
