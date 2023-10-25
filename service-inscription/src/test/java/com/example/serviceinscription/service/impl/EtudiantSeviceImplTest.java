package com.example.serviceinscription.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import com.example.serviceinscription.dto.EtudiantDto;
import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import com.example.serviceinscription.model.Etudiant;
import com.example.serviceinscription.payload.mapper.EtudiantDtoMapper;
import com.example.serviceinscription.repository.EtudiantRepository;

 class EtudiantSeviceImplTest {

    @InjectMocks
    private EtudiantSeviceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private EtudiantDtoMapper etudiantDtoMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testAjouterNouveauEtudiant() {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");

        Mockito.when(etudiantRepository.existsById("12345")).thenReturn(false);
        Mockito.when(etudiantDtoMapper.apply(Mockito.any())).thenReturn(new EtudiantDto("12345",
                "John",
                "Doe",
                "Math"));

        assertDoesNotThrow(() -> etudiantService.ajouterNouveauEtudiant(etudiantDto));
    }

    @Test
     void testAjouterNouveauEtudiantWithExistingId() {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");

        Mockito.when(etudiantRepository.existsById("12345")).thenReturn(true);

        assertThrows(InvalideEtudiantException.class, () -> etudiantService.ajouterNouveauEtudiant(etudiantDto));
    }

    @Test
     void testUpdateEtudiant() {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");

        Mockito.when(etudiantRepository.existsById("12345")).thenReturn(true);
        Mockito.when(etudiantDtoMapper.apply(Mockito.any())).thenReturn(new EtudiantDto("12345",
                "John",
                "Doe",
                "Math"));

        assertDoesNotThrow(() -> etudiantService.updateEtudiant(etudiantDto));
    }

    @Test
     void testUpdateEtudiantWithNonExistingId() {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");

        Mockito.when(etudiantRepository.existsById("12345")).thenReturn(false);

        assertThrows(EtudiantInconnuExecption.class, () -> etudiantService.updateEtudiant(etudiantDto));
    }

    @Test
     void testSupprimerEtudiant() {
        String numeroCarte = "12345";
        Mockito.when(etudiantRepository.existsById(numeroCarte)).thenReturn(true);
        assertDoesNotThrow(() -> etudiantService.supprimerEtudiant(numeroCarte));
    }

    @Test
     void testSupprimerEtudiantWithNonExistingId() {
        String numeroCarte = "12345";
        Mockito.when(etudiantRepository.existsById(numeroCarte)).thenReturn(false);
        assertThrows(EtudiantInconnuExecption.class, () -> etudiantService.supprimerEtudiant(numeroCarte));
    }

    @Test
     void testGetAllEtudiant() {
        List<Etudiant> etudiants = Arrays.asList(new Etudiant(), new Etudiant());
        Mockito.when(etudiantRepository.findAll()).thenReturn(etudiants);
        Mockito.when(etudiantDtoMapper.apply(Mockito.any())).thenReturn(new EtudiantDto("12345",
                "John",
                "Doe",
                "Math")
);

        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiant();

        assertNotNull(etudiantDtos);
        assertEquals(2, etudiantDtos.size());
    }

    @Test
     void testGetEtudiantById() {
        String numCarte = "12345";
        Etudiant etudiant = new Etudiant();
        Mockito.when(etudiantRepository.findByNumCarte(numCarte)).thenReturn(etudiant);
        Mockito.when(etudiantDtoMapper.apply(Mockito.any())).thenReturn(new EtudiantDto("12345",
                "John",
                "Doe",
                "Math"));

        EtudiantDto etudiantDto = etudiantService.getEtudiantById(numCarte);

        assertNotNull(etudiantDto);
    }

    @Test
     void testGetEtudiantByIdWithNonExistingId() {
        String numCarte = "12345";
        Mockito.when(etudiantRepository.findByNumCarte(numCarte)).thenReturn(null);

        EtudiantDto etudiantDto = etudiantService.getEtudiantById(numCarte);

        assertNull(etudiantDto);
    }

    @Test
     void testValidationEtudiant() {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");
        Mockito.when(etudiantRepository.existsById("12345")).thenReturn(false);

        boolean isValid = etudiantService.validationEtudiant(etudiantDto);

        assertTrue(isValid);
    }

    @Test
     void testValidationEtudiantWithExistingId() {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");
        Mockito.when(etudiantRepository.existsById("12345")).thenReturn(true);

        boolean isValid = etudiantService.validationEtudiant(etudiantDto);

        assertFalse(isValid);
    }
}
