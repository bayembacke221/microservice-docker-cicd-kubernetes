package com.example.serviceinscription.exception;


/**
 * Exception lancée si on essaie d'ajouter un étudiant déjà enregistré avec le même numéro de carte
 */
public class InvalideEtudiantException extends Exception {

    public InvalideEtudiantException(String message) {
        super(message);
    }
}
