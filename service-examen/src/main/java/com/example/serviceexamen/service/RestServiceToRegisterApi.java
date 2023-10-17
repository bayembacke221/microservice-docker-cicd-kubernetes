package com.example.serviceexamen.service;

import com.example.serviceexamen.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${clients.inscription.url}", name = "etudiant-service-api")
public interface RestServiceToRegisterApi {

    @GetMapping("etudiant/{numCarte}")
    ResponseEntity<Etudiant> getEtudiantById( @PathVariable("numCarte") String numCarte);

}
