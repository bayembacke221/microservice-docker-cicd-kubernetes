package com.example.serviceinscription.dto;

import lombok.*;



public record EtudiantDto(String numCarte,
                          String prenom,
                          String nom,
                          String classe) {

}
