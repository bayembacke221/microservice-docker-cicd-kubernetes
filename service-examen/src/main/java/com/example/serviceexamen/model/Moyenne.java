package com.example.serviceexamen.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Moyenne {
    @Id
    private String numCarte;
    private String prenom;
    private String nom;
    private double moyenne;
}
