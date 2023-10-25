package com.example.serviceinscription.service.impl;

import com.example.serviceinscription.dto.EtudiantDto;
import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import com.example.serviceinscription.model.Etudiant;
import com.example.serviceinscription.payload.mapper.EtudiantDtoMapper;
import com.example.serviceinscription.repository.EtudiantRepository;
import com.example.serviceinscription.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantSeviceImpl implements EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    EtudiantDtoMapper etudiantDtoMapper;

    /**
     * Ajout d'un etudiant
     * @param etudiant étudiant à ajouter
     * @throws InvalideEtudiantException
     */
    @Override
    public void ajouterNouveauEtudiant(EtudiantDto etudiant) throws InvalideEtudiantException {
        if (validationEtudiant(etudiant)) {
            Etudiant etudiant1 = new Etudiant();
            etudiant1.setNumCarte(etudiant.numCarte());
            etudiant1.setPrenom(etudiant.prenom());
            etudiant1.setNom(etudiant.nom());
            etudiant1.setClasse(etudiant.classe());
            etudiantRepository.save(etudiant1);
        } else throw new InvalideEtudiantException("informations invalides ou étudiant déjà existant dans la base de données");

    }


    /**
     * Modification d'un étudiant
     * @param etudiant etudiant à modifier
     */
    @Override
    public void updateEtudiant(EtudiantDto etudiant) throws EtudiantInconnuExecption {
        if (!etudiantRepository.existsById(etudiant.numCarte())) {
            throw new EtudiantInconnuExecption("Cet étudiant n'existe pas dans la base de données");
        }
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNumCarte(etudiant.numCarte());
        etudiant1.setPrenom(etudiant.prenom());
        etudiant1.setNom(etudiant.nom());
        etudiant1.setClasse(etudiant.classe());
        etudiantRepository.save(etudiant1);
    }


    /**
     * Suppression d'un etudiant par son identifiant (numero carte)
     * @param numeroCarte id etudiant
     * @throws EtudiantInconnuExecption
     */
    @Override
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
    @Override
    public List<EtudiantDto> getAllEtudiant() {
        return etudiantRepository.findAll().stream()
                .map(etudiantDtoMapper)
                .toList();
    }

    /**
     * Recuperation d'un etudiant par son ID (numero carte)
     * @param numCarte numero carte etudiant
     * @return etudiant si trouvé, sinon null
     */
    @Override
    public EtudiantDto getEtudiantById(String numCarte) {
        Etudiant etudiant= etudiantRepository.findByNumCarte(numCarte);

        return etudiantDtoMapper.apply(etudiant);
    }


    /**
     * Validation d'un etudiant en verifiant si le numero carte est déjà enregistré pour un autre étudiant
     * @param etudiant
     * @return boolean booleen permettant de savoir ou pas si l'objet etudiant reçu est valide.
     */
    @Override
    public boolean validationEtudiant(EtudiantDto etudiant) {
        /*
        verifier que l'objet envoyé n'est pas null, mais aussi que l'id (numCarte) donné n'est pas null ou vide
         */
        return etudiant != null &&
                etudiant.numCarte() != null &&
                !etudiant.numCarte().isEmpty() &&
                !etudiantRepository.existsById(etudiant.numCarte());
    }
}
