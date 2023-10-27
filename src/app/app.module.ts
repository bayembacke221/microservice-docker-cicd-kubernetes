import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ServiceAdmissionComponent } from './component/service-admission/service-admission.component';
import { ServiceExamenComponent } from './component/service-examen/service-examen.component';
import { ServiceInscriptionComponent } from './component/service-inscription/service-inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    ServiceAdmissionComponent,
    ServiceExamenComponent,
    ServiceInscriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
