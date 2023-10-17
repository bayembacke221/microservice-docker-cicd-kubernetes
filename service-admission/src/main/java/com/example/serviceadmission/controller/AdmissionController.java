package com.example.serviceadmission.controller;

import com.example.serviceadmission.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admission")
@CrossOrigin("*")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @GetMapping("/all")
    public ResponseEntity getResults() {
        return ResponseEntity.ok(admissionService.getEtudiantsResultats());
    }
}
