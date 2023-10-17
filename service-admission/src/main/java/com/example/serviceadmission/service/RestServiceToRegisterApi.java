package com.example.serviceadmission.service;

import com.example.serviceadmission.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "etudiant-api", url = "http://localhost:8081/etudiant")
public interface RestServiceToRegisterApi {

    /**
     * Recuperation de la liste des etudiants inscrits
     * @return liste des etudiants inscrits
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ResponseEntity<List<Etudiant>> getAllEtudiants();
}
