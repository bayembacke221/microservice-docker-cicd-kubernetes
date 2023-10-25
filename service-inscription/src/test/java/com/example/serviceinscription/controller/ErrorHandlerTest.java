package com.example.serviceinscription.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceinscription.controller.ErrorHandler;
import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class ErrorHandlerTest {

    @Test
     void testHandleInvalideEtudiantException() {
        // GIVEN
        InvalideEtudiantException exception = new InvalideEtudiantException("L'étudiant est invalide");
        ErrorHandler errorHandler = new ErrorHandler();

        // WHEN
        ResponseEntity<Map<String, String>> response = errorHandler.handleInvalideEtudiantException(exception);

        // THEN
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("L'étudiant est invalide", response.getBody().get("erreur"));
    }

    @Test
     void testHandleEtudiantInconnuException() {
        // GIVEN
        EtudiantInconnuExecption exception = new EtudiantInconnuExecption("L'étudiant n'existe pas");
        ErrorHandler errorHandler = new ErrorHandler();

        // WHEN
        ResponseEntity<Map<String, String>> response = errorHandler.handleEtudiantInconnuException(exception);

        // THEN
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("L'étudiant n'existe pas", response.getBody().get("erreur"));
    }
}
