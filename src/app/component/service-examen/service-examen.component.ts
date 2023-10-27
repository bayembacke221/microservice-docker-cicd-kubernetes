import { Component } from '@angular/core';
import {ApiExamenService} from "../../service/api-examen.service";
import Moyenne from "../../model/Moyenne";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Router} from "@angular/router";

@Component({
  selector: 'app-service-examen',
  templateUrl: './service-examen.component.html',
  styleUrls: ['./service-examen.component.css']
})
export class ServiceExamenComponent {
  newMoyenne: Moyenne = {
    prenom: '',
    nom: '',
    numCarte: '',
    moyenne: 0
  };
  moyenneToModify: Moyenne = {
    prenom: '',
    nom: '',
    numCarte: '',
    moyenne: 0
  };
  moyennes = new Array<Moyenne>()
  constructor(private apiExamen: ApiExamenService,
              private modalService: NgbModal,
              private router: Router) { }

  ngOnInit(): void {
    this.apiExamen.getAllMoyenne().subscribe((results) => {
      console.log(this.moyennes);
      this.moyennes = results;
    })
  }

  open(content: any, index?: number) {
    this.modalService.open(content);
    if (index !== undefined) {
      this.moyenneToModify = this.moyennes[index]
    }
  }

  initNewMoyenne() {
    this.newMoyenne = {
      nom: '',
      prenom: '',
      moyenne: 0,
      numCarte: ''
    };
    this.moyenneToModify = {
      nom: '',
      prenom: '',
      moyenne: 0,
      numCarte: ''
    };
  }

  enregistrerMoyenne() {
    try {
      this.apiExamen.ajoutMoyenne(this.newMoyenne).subscribe();
      const exitButton = document.getElementById("close-btn")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.initNewMoyenne()
      this.router.navigateByUrl('/service-examen') // rechargement rapide de la page pour recuperer les valeurs
    } catch (err) {
      console.log(err)
      alert("erreur lors de l'enregistrement de la moyenne")
      this.initNewMoyenne()
    }
  }

  modifierMoyenne() {
    try {
      this.apiExamen.modifierMoyenne(this.moyenneToModify).subscribe();
      const exitButton = document.getElementById("close-btn-modify")
      if (exitButton != undefined){
        exitButton.click()
      }
      //this.etudiants.push(this.newEtudiant)
      this.initNewMoyenne()
    } catch (err) {
      console.log(err)
      alert("erreur lors de la modification de la moyenne")
      this.initNewMoyenne()
    }
  }

  supprimerMoyenne(numeroCarte: string) {
    try {
      this.apiExamen.supprimerMoyenne(numeroCarte).subscribe()
      this.moyennes = this.moyennes.filter(moy => moy.numCarte !== numeroCarte)
    } catch (err) {
      console.log(err)
      alert("erreur lors de la suppression de la moyenne")
    }
  }

}
