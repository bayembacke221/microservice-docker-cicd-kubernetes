import { Component } from '@angular/core';
import {ApiAdmissionService} from "../../service/api-admission.service";
import Admis from "../../model/Admis";

@Component({
  selector: 'app-service-admission',
  templateUrl: './service-admission.component.html',
  styleUrls: ['./service-admission.component.css']
})
export class ServiceAdmissionComponent {
  resultatClasse: any = {
    'absent': 'bg-primary',
    'non-admis': 'bg-danger',
    'admis': 'bg-success'
  };
  listeAdmission: any = new Array<Admis>();
  constructor(private apiAdmissionService: ApiAdmissionService) { }

  ngOnInit(): void {
    this.apiAdmissionService.getListeAdmission().subscribe((results) => {
      this.listeAdmission = results;
    })
  }

  getClasse(typeResultat: string) {
    return this.resultatClasse[typeResultat]
  }

}
