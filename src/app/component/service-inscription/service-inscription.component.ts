import { Component, OnInit } from '@angular/core';

import {ApiEtudiantService} from "../../service/api-etudiant.service";
import Etudiant from "../../model/Etudiant";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
@Component({
  selector: 'app-service-inscription',
  templateUrl: './service-inscription.component.html',
  styleUrls: ['./service-inscription.component.css']
})
export class ServiceInscriptionComponent {
  newEtudiant: Etudiant = {
    nom: '',
    prenom: '',
    classe: '',
    numCarte: ''
  };
  etudiantToModify: Etudiant = {
    nom: '',
    prenom: '',
    classe: '',
    numCarte: ''
  };

  etudiants = new Array<Etudiant>();
  constructor(private apiEtudiantService: ApiEtudiantService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.apiEtudiantService.getListeEtudiant().subscribe((results) => {
      console.log(results)
      this.etudiants = results;
    })

  }

  open(content: any, index?: number) {
    this.modalService.open(content);
    if (index !== undefined) {
      this.etudiantToModify = this.etudiants[index]
    }
  }

  initNewEtudiant() {
    this.newEtudiant = {
      nom: '',
      prenom: '',
      classe: '',
      numCarte: ''
    };
    this.etudiantToModify = {
      nom: '',
      prenom: '',
      classe: '',
      numCarte: ''
    };
  }

  enregistrerEtudiant() {
    try {
      this.apiEtudiantService.ajoutEtudiant(this.newEtudiant).subscribe();
      const exitButton = document.getElementById("close-btn")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.etudiants.push(this.newEtudiant)
      this.initNewEtudiant()
    } catch (err) {
      console.log(err)
      alert("erreur lors de l'enregistrement de l'étudiant")
      this.initNewEtudiant()
    }
  }

  modifierEtudiant() {
    try {
      this.apiEtudiantService.modifierEtudiant(this.etudiantToModify).subscribe();
      const exitButton = document.getElementById("close-btn-modify")
      if (exitButton != undefined){
        exitButton.click()
      }
      //this.etudiants.push(this.newEtudiant)
      this.initNewEtudiant()
    } catch (err) {
      console.log(err)
      alert("erreur lors de la modification de l'étudiant")
      this.initNewEtudiant()
    }
  }

  supprimerEtudiant(numeroCarte: string) {
    try {
      this.apiEtudiantService.supprimerEtudiant(numeroCarte).subscribe()
      this.etudiants = this.etudiants.filter(etu => etu.numCarte !== numeroCarte)
    } catch (err) {
      console.log(err)
      alert("erreur lors de la suppression de l'étudiant")
    }
  }

}
