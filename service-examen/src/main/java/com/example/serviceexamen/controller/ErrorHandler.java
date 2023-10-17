package com.example.serviceexamen.controller;

import com.example.serviceexamen.exception.EtudiantInconnuException;
import com.example.serviceexamen.exception.InvalideMoyenneException;
import com.example.serviceexamen.exception.MoyenneInconnuException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
    private static final Map<String, String> error = new HashMap<>();

    /**
     * gestion erreur etudiant inconnu
     * @param exception
     * @return
     */
    @ExceptionHandler(EtudiantInconnuException.class)
    public ResponseEntity handleEtudiantInconnuException(EtudiantInconnuException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    /**
     * gestion erreur moyenne invalide (information manquant ou mal formé)
     * @param exception
     * @return
     */
    @ExceptionHandler(InvalideMoyenneException.class)
    public ResponseEntity handleInvalideMoyenneException(InvalideMoyenneException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    /**
     * gestion erreur moyenne inconnue , cad moyenne inexistante pour un ID donné
     * @param exception
     * @return
     */
    @ExceptionHandler(MoyenneInconnuException.class)
    public ResponseEntity handleMoyenneInconnuException(MoyenneInconnuException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}
