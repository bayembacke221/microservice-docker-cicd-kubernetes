package com.example.serviceadmission.service;

import com.example.serviceadmission.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "etudiant-api",
        url = "${clients.inscription.url}"
)
public interface RestServiceToRegisterApi {

    /**
     * Recuperation de la liste des etudiants inscrits
     * @return liste des etudiants inscrits
     */
    @GetMapping("etudiant/all")
    ResponseEntity<List<Etudiant>> getAllEtudiants();
}
