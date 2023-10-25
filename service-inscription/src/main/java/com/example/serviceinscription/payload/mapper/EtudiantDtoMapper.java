package com.example.serviceinscription.payload.mapper;

import com.example.serviceinscription.dto.EtudiantDto;
import com.example.serviceinscription.model.Etudiant;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EtudiantDtoMapper implements Function<Etudiant, EtudiantDto> {

    @Override
    public EtudiantDto apply(Etudiant etudiant) {
        return new EtudiantDto(
                etudiant.getNumCarte(),
                etudiant.getPrenom(),
                etudiant.getNom(),
                etudiant.getClasse()

        );
    }
}
