package com.example.serviceinscription.controller;

import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import com.example.serviceinscription.model.Etudiant;
import com.example.serviceinscription.service.EtudiantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EtudiantControllerTest {

    @Mock
    private EtudiantService etudiantService;

    @InjectMocks
    private EtudiantController etudiantController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAjouterEtudiant() throws InvalideEtudiantException {
        // GIVEN
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","Lic1");

        // WHEN
        etudiantController.ajouterEtudiant(etudiant);

        // THEN
        verify(etudiantService, times(1)).ajouterNouveauEtudiant(etudiant);
    }


    @Test
    public void testGetAllEtudiants() {
        // GIVEN
        List<Etudiant> etudiants = new ArrayList<>();

        // WHEN
        when(etudiantService.getAllEtudiant()).thenReturn(etudiants);

        ResponseEntity<List<Etudiant>> response = etudiantController.getAllEtudiant();

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(etudiants, response.getBody());
        verify(etudiantService, times(1)).getAllEtudiant();
    }

    @Test
    public void testGetEtudiantById() throws EtudiantInconnuExecption {
        // GIVEN
        String numCarte = "123456789";
        Etudiant etudiant = new Etudiant(numCarte, "Doe", "John","Lic1");

        // WHEN
        when(etudiantService.getEtudiantById(numCarte)).thenReturn(etudiant);

        ResponseEntity<Etudiant> response = etudiantController.getEtudiantById(numCarte);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(etudiant, response.getBody());
        verify(etudiantService, times(1)).getEtudiantById(numCarte);
    }
    @Test
    public void testModifierEtudiant() throws EtudiantInconnuExecption {
        // GIVEN
        String numCarte = "123456789";
        Etudiant etudiant = new Etudiant(numCarte, "Doe", "John","Lic1");

        // WHEN
        etudiantController.modifierEtudiant(etudiant);

        // THEN
        verify(etudiantService, times(1)).updateEtudiant(etudiant);
    }

    @Test
    public void testSupprimerEtudiant() throws EtudiantInconnuExecption {
        // GIVEN
        String numCarte = "123456789";

        // WHEN
        etudiantController.supprimerEtudiant(numCarte);

        // THEN
        verify(etudiantService, times(1)).supprimerEtudiant(numCarte);
    }

    @Test
    public void testGetAllEtudiants_ServiceRetourneListeVide() {
        // GIVEN
        List<Etudiant> etudiants = new ArrayList<>();

        // WHEN
        when(etudiantService.getAllEtudiant()).thenReturn(etudiants);

        ResponseEntity<List<Etudiant>> response = etudiantController.getAllEtudiant();

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(etudiants, response.getBody());
        verify(etudiantService, times(1)).getAllEtudiant();
    }



}
