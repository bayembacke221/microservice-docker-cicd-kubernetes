package com.example.serviceinscription.controller;

import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
    private static final Map<String, String> error = new HashMap<>();

    /**
     * fonction appelée pour gerer l'exception concernant l'ajout d'un étudiant invalide
     * @param exception
     * @return
     */
    @ExceptionHandler(InvalideEtudiantException.class)
    public ResponseEntity handleInvalideEtudiantException(InvalideEtudiantException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }


    /**
     * fonction appelée pour gerer l'exception concernant un étudiant inconnu de la base de données lors de la modification ou de la suppression
     * @param exception
     * @return
     */
    @ExceptionHandler(EtudiantInconnuExecption.class)
    public ResponseEntity handleEtudiantInconnuException(EtudiantInconnuExecption exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
