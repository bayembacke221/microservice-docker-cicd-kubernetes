package com.example.serviceadmission.service;

import com.example.serviceadmission.model.Moyenne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "examen-api", url = "http://localhost:8082/moyenne")
public interface RestServiceToGradesApi {

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ResponseEntity<List<Moyenne>> getAllMoyenne();

    @RequestMapping(method = RequestMethod.GET, value = "/{numCarte}")
    ResponseEntity<Moyenne> getMoyenneByNumCarte(@PathVariable("numCarte") String numCarte);

}
