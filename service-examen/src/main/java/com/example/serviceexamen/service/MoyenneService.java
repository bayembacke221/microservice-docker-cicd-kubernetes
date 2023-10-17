package com.example.serviceexamen.service;

import com.example.serviceexamen.exception.EtudiantInconnuException;
import com.example.serviceexamen.exception.InvalideMoyenneException;
import com.example.serviceexamen.exception.MoyenneInconnuException;
import com.example.serviceexamen.model.Etudiant;
import com.example.serviceexamen.model.Moyenne;
import com.example.serviceexamen.model.MoyennePayload;
import com.example.serviceexamen.repository.MoyenneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoyenneService {
    @Autowired
    MoyenneRepository moyenneRepository;

    @Autowired
    RestServiceToRegisterApi restServiceToRegisterApi;

    /**
     * Ajout d'une moyenne pour un etudiant existant
     * @param moyenne
     * @throws Exception
     */
    public void ajoutMoyenne(MoyennePayload moyenne) throws Exception {
        if (moyenne.getNumCarte() == null) {
            throw new InvalideMoyenneException("Le numero de carte ne doit pas etre null");
        }
        ResponseEntity<Etudiant> response = restServiceToRegisterApi.getEtudiantById(moyenne.getNumCarte());
        Etudiant etudiant = response.getBody();
        if (etudiant == null) {
            throw new EtudiantInconnuException("Etudiant non enregistré dans la base de données, l'étudiant n'est pas inscrit ");
        }
        Moyenne moyenneToSave = new Moyenne();
        moyenneToSave.setMoyenne(moyenne.getMoyenne());
        moyenneToSave.setNom(etudiant.getNom());
        moyenneToSave.setPrenom(etudiant.getPrenom());
        moyenneToSave.setNumCarte(moyenne.getNumCarte());
        moyenneRepository.save(moyenneToSave);
    }

    /**
     * Mise à jour de la moyenne pour un étudiant
     * @param payload
     * @throws Exception
     */
    public void updateMoyenne(MoyennePayload payload) throws Exception {

        if (payload.getNumCarte() == null) {
            throw new InvalideMoyenneException("Le numero de carte ne doit pas etre null");
        }

        if (!moyenneRepository.existsById(payload.getNumCarte())) {
            throw new MoyenneInconnuException("Aucune Moyenne enregistré pour ce numero de carte ");
        }
        Moyenne moyenneToUpdate = moyenneRepository.findByNumCarte(payload.getNumCarte());
        moyenneToUpdate.setMoyenne(payload.getMoyenne());
        moyenneRepository.save(moyenneToUpdate);
    }


    /**
     * suppression d'une moyenne via l'ID de l'etudiant
     * @param numeroCarte
     * @throws MoyenneInconnuException
     */
    public void supprimerMoyenne(String numeroCarte) throws MoyenneInconnuException {
        if (!moyenneRepository.existsById(numeroCarte)) {
            throw new MoyenneInconnuException("Aucune Moyenne enregistré pour ce numero de carte ");
        }
        moyenneRepository.deleteById(numeroCarte);
    }

    /**
     * Recuperation de la liste des moyennes
     * @return
     */
    public List<Moyenne> getAll() {
        return moyenneRepository.findAll();
    }

    /**
     * Recuperation de la moyenne d'un etudiant via son ID
     * @param numeroCarte
     * @return
     */
    public Moyenne getMoyenneById(String numeroCarte) {
        return moyenneRepository.findByNumCarte(numeroCarte);
    }



}
