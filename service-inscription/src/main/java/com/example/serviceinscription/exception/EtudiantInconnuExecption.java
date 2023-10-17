package com.example.serviceinscription.exception;

/**
 * Exception lancée si on essaie une modification sur un étudiant qui n'existe pas
 */
public class EtudiantInconnuExecption extends Exception{
    public EtudiantInconnuExecption(String message) {
        super(message);
    }
}
