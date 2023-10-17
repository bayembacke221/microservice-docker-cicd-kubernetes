package com.example.serviceexamen.service;

import com.example.serviceexamen.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8081/etudiant", name = "etudiant-service-api")
public interface RestServiceToRegisterApi {

    @RequestMapping(method = RequestMethod.GET, value = "/{numCarte}")
    ResponseEntity<Etudiant> getEtudiantById( @PathVariable("numCarte") String numCarte);

}
