package com.example.serviceexamen.controller;

import com.example.serviceexamen.exception.MoyenneInconnuException;
import com.example.serviceexamen.model.Moyenne;
import com.example.serviceexamen.model.MoyennePayload;
import com.example.serviceexamen.service.MoyenneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Rest controller pour exposer le service de gestion des examens
 */
@RestController
@RequestMapping("moyenne")
@CrossOrigin("*")
public class MoyenneController {
    @Autowired
    private MoyenneService moyenneService;


    /**
     * Recuperation liste des etudiants
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<Moyenne>> getAllMoyenne() {
        return ResponseEntity.ok(moyenneService.getAll());
    }

    /**
     * Recuperation moyenne avec Id etudiant
     * @param numeroCarte
     * @return
     */
    @GetMapping("/{idEtudiant}")
    public ResponseEntity getMoyenneById(
            @PathVariable("idEtudiant") String numeroCarte
    ) {
        return ResponseEntity.ok(moyenneService.getMoyenneById(numeroCarte));
    }


    /**
     * ajouter moyenne etudiant
     * @param payload
     * @return
     * @throws Exception
     */
    @PostMapping
    public ResponseEntity ajouterMoyenneEtudiant(
            @RequestBody MoyennePayload payload
    ) throws Exception {
        moyenneService.ajoutMoyenne(payload);
        return ResponseEntity.ok().build();
    }

    /**
     * modifier moyenne etudiant
     * @param payload
     * @return
     * @throws Exception
     */
    @PutMapping
    public ResponseEntity modifierMoyenneEtudiant(
            @RequestBody MoyennePayload payload
    ) throws Exception {
        moyenneService.updateMoyenne(payload);
        return ResponseEntity.ok().build();
    }

    /**
     * suppresssion d'une moyenne d'un etudiant à partir de son ID
     * @param numeroCarte ID
     * @return response vide avec un statut OK (code 200) si tout s'est bien passé
     * @throws MoyenneInconnuException
     */
    @DeleteMapping("/{idEtudiant}")
    public ResponseEntity supprimerMoyenne(
            @PathVariable("idEtudiant") String numeroCarte
    ) throws MoyenneInconnuException {
        moyenneService.supprimerMoyenne(numeroCarte);
        return ResponseEntity.ok().build();
    }


}
