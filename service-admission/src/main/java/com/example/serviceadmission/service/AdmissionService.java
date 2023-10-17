package com.example.serviceadmission.service;

import com.example.serviceadmission.model.Admis;
import com.example.serviceadmission.model.Etudiant;
import com.example.serviceadmission.model.Moyenne;
import com.example.serviceadmission.model.TypeResultat;
import com.example.serviceadmission.repository.AdmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    RestServiceToGradesApi restServiceToGradesApi;

    @Autowired
    RestServiceToRegisterApi restServiceToRegisterApi;


    public List<Admis> getEtudiantsResultats() {
        List<Etudiant> etudiants = restServiceToRegisterApi.getAllEtudiants().getBody();
        Collection<Moyenne> moyennes = restServiceToGradesApi.getAllMoyenne().getBody();
        List<Admis> admisList = new ArrayList<>();
        if (etudiants != null && moyennes != null) {
            etudiants.forEach(etudiant -> {
                Moyenne moyenne = restServiceToGradesApi.getMoyenneByNumCarte(etudiant.getNumCarte()).getBody();
                if (moyenne == null) {
                    admisList.add(new Admis(
                            etudiant.getNumCarte(),
                            etudiant.getPrenom(),
                            etudiant.getNom(),
                            etudiant.getClasse(),
                            TypeResultat.ABSENT.getValue())
                    );
                }else {
                    admisList.add(new Admis(
                            etudiant.getNumCarte(),
                            etudiant.getPrenom(),
                            etudiant.getNom(),
                            etudiant.getClasse(),
                            moyenne.getMoyenne() > 12 ? TypeResultat.ADMIS.getValue() : TypeResultat.NON_ADMIS.getValue()
                            )
                    );
                }
            });
        }
        return admissionRepository.saveAll(admisList);
    }

}
