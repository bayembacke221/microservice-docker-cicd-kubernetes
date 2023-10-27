import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiAdmissionService {

  private static urlApi = 'http://localhost:8083/admission';
  constructor(private http: HttpClient) { }

  getListeAdmission() {
    return this.http.get(`${ApiAdmissionService.urlApi}/all`)
  }
}
