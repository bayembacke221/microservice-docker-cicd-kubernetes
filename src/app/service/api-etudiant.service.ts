import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, ObservableInput} from "rxjs";
import Etudiant from "../model/Etudiant";
@Injectable({
  providedIn: 'root'
})
export class ApiEtudiantService {

  private static urlEtudiantApi = "http://localhost:8081/etudiant"
  constructor(private http: HttpClient) { }

  /**
   * Recuperation de la liste des etudiants
   */
  public getListeEtudiant() {
    return this.http.get(`${ApiEtudiantService.urlEtudiantApi}/all`).pipe(catchError(this.handleError))
  }

  /**
   * ajout étudiant
   * @param etudiant
   */
  public ajoutEtudiant(etudiant: Etudiant) {
    return this.http.post(`${ApiEtudiantService.urlEtudiantApi}`, etudiant).pipe(catchError(this.handleError))
  }


  /**
   * modification etudiant
   * @param etudiant
   */
  public modifierEtudiant(etudiant: Etudiant) {
    return this.http.put(`${ApiEtudiantService.urlEtudiantApi}`, etudiant).pipe(catchError(this.handleError))
  }

  /**
   * suppression etudiant
   * @param numeroCarteEtudiant
   */
  public supprimerEtudiant(numeroCarteEtudiant: string) {
    return this.http.delete(`${ApiEtudiantService.urlEtudiantApi}/${numeroCarteEtudiant}`).pipe(catchError(this.handleError))
  }

  handleError(error: any, caught: Observable<any>) : ObservableInput<any>{
    throw new Error(error)
  }

}
