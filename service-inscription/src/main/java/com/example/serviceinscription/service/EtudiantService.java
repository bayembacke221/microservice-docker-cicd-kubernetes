package com.example.serviceinscription.service;

import com.example.serviceinscription.dto.EtudiantDto;
import com.example.serviceinscription.exception.EtudiantInconnuExecption;
import com.example.serviceinscription.exception.InvalideEtudiantException;

import java.util.List;


public interface EtudiantService {

    public void ajouterNouveauEtudiant(EtudiantDto etudiant) throws InvalideEtudiantException;
    public void updateEtudiant(EtudiantDto etudiant) throws EtudiantInconnuExecption;
    public void supprimerEtudiant(String numeroCarte) throws EtudiantInconnuExecption;
    public List<EtudiantDto> getAllEtudiant();
    public EtudiantDto getEtudiantById(String numCarte);
    public boolean validationEtudiant(EtudiantDto etudiant);


}
