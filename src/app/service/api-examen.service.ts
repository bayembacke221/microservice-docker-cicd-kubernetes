import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, ObservableInput} from "rxjs";
import Moyenne from "../model/Moyenne";

@Injectable({
  providedIn: 'root'
})
export class ApiExamenService {

  private static urlApiExamen = "http://localhost:8082/moyenne"
  constructor(private http: HttpClient) { }

  getAllMoyenne() {
    return this.http.get(`${ApiExamenService.urlApiExamen}/all`).pipe(catchError(this.handleError))
  }

  /**
   * ajout moyenne
   * @param moyenne
   */
  public ajoutMoyenne(moyenne: Moyenne) {
    return this.http.post(`${ApiExamenService.urlApiExamen}`, moyenne).pipe(catchError(this.handleError))
  }


  /**
   * modification moyenne
   * @param moyenne
   */
  public modifierMoyenne(moyenne: Moyenne) {
    return this.http.put(`${ApiExamenService.urlApiExamen}`, moyenne).pipe(catchError(this.handleError))
  }

  /**
   * suppression moyenne
   * @param numeroCarteEtudiant
   */
  public supprimerMoyenne(numeroCarteEtudiant: string) {
    return this.http.delete(`${ApiExamenService.urlApiExamen}/${numeroCarteEtudiant}`).pipe(catchError(this.handleError))
  }

  handleError(error: any, caught: Observable<any>) : ObservableInput<any>{
    throw new Error(error)
  }
}
