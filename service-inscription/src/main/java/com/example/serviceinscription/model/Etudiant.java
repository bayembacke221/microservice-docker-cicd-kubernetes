package com.example.serviceinscription.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    private String numCarte;
    private String prenom;
    private String nom;
    private String classe;
}
