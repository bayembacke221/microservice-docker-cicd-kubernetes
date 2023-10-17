package com.example.serviceadmission.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor()
@NoArgsConstructor
public class Admis {
    @Id
    private String numCarte;
    private String prenom;
    private String nom;
    private String classe;
    private String resultat;
}
