package com.example.serviceinscription.controller;


import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import com.example.serviceinscription.model.Etudiant;
import com.example.serviceinscription.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Rest controller permettant d'exposer le service d'inscription des etudiants
 */
@RestController
@RequestMapping("etudiant")
@CrossOrigin("*")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    /**
     * Recuperation de la liste des étudiants
     * @return Liste des etudiants
     */
    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> getAllEtudiant() {
        return ResponseEntity.ok(etudiantService.getAllEtudiant());
    }

    /**
     * recuperation etudiant par son ID
     * @param numCarte
     * @return
     */
    @GetMapping("/{numCarte}")
    public ResponseEntity<Etudiant> getEtudiantById(
            @PathVariable("numCarte") String numCarte) {
        return ResponseEntity.ok(etudiantService.getEtudiantById(numCarte));
    }

    /**
     * Ajout d'un nouveau etudiant
     * @param etudiant
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws InvalideEtudiantException
     */
    @PostMapping
    public ResponseEntity ajouterEtudiant(
            @RequestBody  Etudiant etudiant) throws InvalideEtudiantException {
        etudiantService.ajouterNouveauEtudiant(etudiant);
        return ResponseEntity.ok().build();
    }


    /**
     * modification d'un etudiant
     * @param etudiant
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws EtudiantInconnuExecption
     */
    @PutMapping
    public ResponseEntity modifierEtudiant(
            @RequestBody  Etudiant etudiant) throws EtudiantInconnuExecption {
        etudiantService.updateEtudiant(etudiant);
        return ResponseEntity.ok().build();
    }


    /**
     * suppression d'un étudiant
     * @param numeroCarte
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws EtudiantInconnuExecption
     */
    @DeleteMapping("/{idEtudiant}")
    public ResponseEntity supprimerEtudiant(
            @PathVariable("idEtudiant") String numeroCarte
    ) throws EtudiantInconnuExecption {
        etudiantService.supprimerEtudiant(numeroCarte);
        return ResponseEntity.ok().build();
    }


}
