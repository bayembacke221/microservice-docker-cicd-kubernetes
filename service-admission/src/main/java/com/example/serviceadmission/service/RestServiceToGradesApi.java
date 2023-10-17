package com.example.serviceadmission.service;

import com.example.serviceadmission.model.Moyenne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "examen-api",
        url = "${clients.examen.url}"
)
public interface RestServiceToGradesApi {

    @GetMapping("moyenne/all")
    ResponseEntity<List<Moyenne>> getAllMoyenne();

    @GetMapping("moyenne/{numCarte}")
    ResponseEntity<Moyenne> getMoyenneByNumCarte(@PathVariable("numCarte") String numCarte);

}
