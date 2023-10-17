package com.example.serviceexamen.exception;

/**
 * Exception lancée si on essaie une modification sur un étudiant qui n'existe pas
 */
public class EtudiantInconnuException extends Exception{
    public EtudiantInconnuException(String message) {
        super(message);
    }
}
