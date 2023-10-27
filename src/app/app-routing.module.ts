import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ServiceInscriptionComponent} from "./component/service-inscription/service-inscription.component";
import {ServiceExamenComponent} from "./component/service-examen/service-examen.component";
import {ServiceAdmissionComponent} from "./component/service-admission/service-admission.component";

const routes: Routes = [
  {
    component: ServiceInscriptionComponent,
    path: 'service-inscription'
  },
  {
    component: ServiceExamenComponent,
    path: 'service-examen'
  },
  {
    component: ServiceAdmissionComponent,
    path: 'service-admission'
  },
  {
    path: '',
    component: ServiceInscriptionComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
