package com.example.serviceinscription.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Etudiant {
    @Id
    private String numCarte;
    private String prenom;
    private String nom;
    private String classe;
}
