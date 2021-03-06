import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AdminRoutingModule } from './admin-routing.module';
import { AgendaComponent } from './components/agenda/agenda.component';
import { CrearAgendaComponent } from './components/crearAgenda/crearAgenda.component';
import { ListadoAgendasComponent } from './components/listadoAgendas/listadoAgendas.component';
import { DoctorComponent } from './components/doctor/doctor.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { SharedModule } from './../shared/shared.module';

@NgModule({
  declarations: [
    AgendaComponent,
    DoctorComponent,
    CrearAgendaComponent,
    ListadoAgendasComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    FontAwesomeModule,
    NgxPaginationModule,
    SharedModule
  ]
})
export class AdminModule { }
