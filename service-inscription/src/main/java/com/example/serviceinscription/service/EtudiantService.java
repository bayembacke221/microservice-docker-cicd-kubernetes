package com.example.serviceinscription.service;

import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import com.example.serviceinscription.model.Etudiant;
import com.example.serviceinscription.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    /**
     * Ajout d'un etudiant
     * @param etudiant étudiant à ajouter
     * @throws InvalideEtudiantException
     */
    public void ajouterNouveauEtudiant(Etudiant etudiant) throws InvalideEtudiantException {
        if (validationEtudiant(etudiant)) {
            etudiantRepository.save(etudiant);
        } else throw new InvalideEtudiantException("informations invalides ou étudiant déjà existant dans la base de données");

    }


    /**
     * Modification d'un étudiant
     * @param etudiant etudiant à modifier
     */
    public void updateEtudiant(Etudiant etudiant) throws EtudiantInconnuExecption {
        if (!etudiantRepository.existsById(etudiant.getNumCarte())) {
            throw new EtudiantInconnuExecption("Cet étudiant n'existe pas dans la base de données");
        }
        etudiantRepository.save(etudiant);
    }


    /**
     * Suppression d'un etudiant par son identifiant (numero carte)
     * @param numeroCarte id etudiant
     * @throws EtudiantInconnuExecption
     */
    public void supprimerEtudiant(String numeroCarte) throws EtudiantInconnuExecption {
        if (!etudiantRepository.existsById(numeroCarte)) {
            throw new EtudiantInconnuExecption("Cet étudiant n'existe pas dans la base de données");
        }
        etudiantRepository.deleteById(numeroCarte);
    }

    /**
     * recupération des etudiants enregistrés dans la bdd
     * @return liste etudiants enregistrés
     */
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    /**
     * Recuperation d'un etudiant par son ID (numero carte)
     * @param numCarte numero carte etudiant
     * @return etudiant si trouvé, sinon null
     */
    public Etudiant getEtudiantById(String numCarte) {
        return etudiantRepository.findByNumCarte(numCarte);
    }


    /**
     * Validation d'un etudiant en verifiant si le numero carte est déjà enregistré pour un autre étudiant
     * @param etudiant
     * @return boolean booleen permettant de savoir ou pas si l'objet etudiant reçu est valide.
     */
    private boolean validationEtudiant(Etudiant etudiant) {
        /*
        verifier que l'objet envoyé n'est pas null, mais aussi que l'id (numCarte) donné n'est pas null ou vide
         */
        return etudiant != null &&
                etudiant.getNumCarte() != null &&
                !etudiant.getNumCarte().isEmpty() &&
                !etudiantRepository.existsById(etudiant.getNumCarte());
    }
}
