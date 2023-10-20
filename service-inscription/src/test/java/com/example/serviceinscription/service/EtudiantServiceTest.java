package com.example.serviceinscription.service;

import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import com.example.serviceinscription.model.Etudiant;
import com.example.serviceinscription.repository.EtudiantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EtudiantServiceTest {

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @BeforeEach
    public void setUp() {
        etudiantRepository.deleteAll();
    }

    @Test
    public void testAjouterNouveauEtudiant_EtudiantValide_EtudiantEnregistre() throws InvalideEtudiantException {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");

        // Act
        etudiantService.ajouterNouveauEtudiant(etudiant);

        // Assert
        List<Etudiant> etudiants = etudiantRepository.findAll();
        Assertions.assertEquals(1, etudiants.size());
        Assertions.assertEquals(etudiant, etudiants.get(0));
    }

    @Test
    public void testAjouterNouveauEtudiant_EtudiantInvalide_ExceptionLevée() {
        // Arrange
        Etudiant etudiant = new Etudiant(null, "Doe", "John","dd");

        // Assert
        Assertions.assertThrows(InvalideEtudiantException.class, () -> etudiantService.ajouterNouveauEtudiant(etudiant));
    }

    @Test
    public void testAjouterNouveauEtudiant_EtudiantExistant_ExceptionLevée() throws InvalideEtudiantException {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");
        etudiantRepository.save(etudiant);

        // Assert
        Assertions.assertThrows(InvalideEtudiantException.class, () -> etudiantService.ajouterNouveauEtudiant(etudiant));
    }

    @Test
    public void testUpdateEtudiant_EtudiantValide_EtudiantMisAJour() throws EtudiantInconnuExecption {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");
        etudiantRepository.save(etudiant);

        // Act
        etudiant.setNom("MettreAJour");
        etudiantService.updateEtudiant(etudiant);

        // Assert
        Etudiant etudiantModifie = etudiantRepository.findByNumCarte(etudiant.getNumCarte());
        Assertions.assertEquals("MettreAJour", etudiantModifie.getNom());
    }

    @Test
    public void testUpdateEtudiant_EtudiantInconnu_ExceptionLevée() {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");

        // Assert
        Assertions.assertThrows(EtudiantInconnuExecption.class, () -> etudiantService.updateEtudiant(etudiant));
    }

    @Test
    public void testSupprimerEtudiant_EtudiantValide_EtudiantSupprimé() throws EtudiantInconnuExecption {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");
        etudiantRepository.save(etudiant);

        // Act
        etudiantService.supprimerEtudiant(etudiant.getNumCarte());

        // Assert
        Assertions.assertFalse(etudiantRepository.existsById(etudiant.getNumCarte()));
    }

    @Test
    public void testGetAllEtudiant_EtudiantsEnregistres_ListeEtudiantsRetournee() {
        // Arrange
        Etudiant etudiant1 = new Etudiant("123456789", "Doe", "John","dd");
        Etudiant etudiant2 = new Etudiant("987654321", "Smith", "Jane","dd");
        etudiantRepository.save(etudiant1);
        etudiantRepository.save(etudiant2);

        // Act
        List<Etudiant> etudiants = etudiantService.getAllEtudiant();

        // Assert
        Assertions.assertEquals(2, etudiants.size());
        Assertions.assertEquals(etudiant1, etudiants.get(0));
        Assertions.assertEquals(etudiant2, etudiants.get(1));
    }
    @Test
    public void testGetEtudiantById_EtudiantExistant_EtudiantRetournee() throws EtudiantInconnuExecption {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");
        etudiantRepository.save(etudiant);

        // Act
        Etudiant etudiantRecupere = etudiantService.getEtudiantById(etudiant.getNumCarte());

        // Assert
        Assertions.assertEquals(etudiant, etudiantRecupere);
    }
    @Test
    public void testValidationEtudiant_EtudiantValide_RetourneTrue() {
        // Arrange
        Etudiant etudiant = new Etudiant("123456789", "Doe", "John","dd");

        // Act
        boolean estValide = etudiantService.validationEtudiant(etudiant);

        // Assert
        Assertions.assertTrue(estValide);
    }

    @Test
    public void testValidationEtudiant_EtudiantInvalide_RetourneFalse() {
        // Arrange
        Etudiant etudiant = new Etudiant(null, "Doe", "John","dd");

        // Act
        boolean estValide = etudiantService.validationEtudiant(etudiant);

        // Assert
        Assertions.assertFalse(estValide);
    }


}