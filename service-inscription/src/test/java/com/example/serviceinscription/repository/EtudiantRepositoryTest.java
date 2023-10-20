package com.example.serviceinscription.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceinscription.model.Etudiant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EtudiantRepositoryTest {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Test
    public void ajouterNouveauEtudiant() {

        Etudiant etudiant = etudiantRepository.save(new Etudiant("20180834", "Moustapha", "Diop", "Lic1"));
        assertNotNull(etudiant);
        assertEquals("20180834", etudiant.getNumCarte());
    }

    @Test
    public void updateEtudiant(){
        Etudiant etudiant = etudiantRepository.save(new Etudiant("20180834", "Moustapha", "Diop", "Lic1"));
        etudiant.setNom("Fall");
        etudiantRepository.save(etudiant);
        assertEquals("Fall", etudiant.getNom());
    }
    @Test
    public void findByNumCarte(){
        Etudiant etudiant = etudiantRepository.findByNumCarte("20180834");
        assertNotNull(etudiant);
        assertEquals("20180834", etudiant.getNumCarte());

    }
    @Test
    public void getAllEtudiant(){
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("2018084DE", "Moustapha", "Diop", "Lic1"));
        etudiants.add(new Etudiant("201707JDH", "Khadim", "Fall", "Lic2"));
        etudiants.add(new Etudiant("2018834DK", "Moussa", "Diop", "Lic1"));
        etudiantRepository.saveAll(etudiants);

        List<Etudiant> etudiantList = (List<Etudiant>) etudiantRepository.findAll();

        Assertions.assertThat(etudiantList).hasSizeGreaterThanOrEqualTo(1);
    }

    @Test
    public void deleteEtudiant(){
        Etudiant etudiant = etudiantRepository.save(new Etudiant("20180834", "Moustapha", "Diop", "Lic1"));
        etudiantRepository.delete(etudiantRepository.findByNumCarte(etudiant.getNumCarte()));

        Etudiant etudiant1 = null;

        Etudiant etudiant2 = etudiantRepository.findByNumCarte(etudiant.getNumCarte());

        if (etudiant2 != null){
            etudiant1 = etudiant2;
        }
        Assertions.assertThat(etudiant1).isNull();
    }

}