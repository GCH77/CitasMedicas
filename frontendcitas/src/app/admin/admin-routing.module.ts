import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AgendaComponent } from './components/agenda/agenda.component';
import { CrearAgendaComponent } from './components/crearAgenda/crearAgenda.component';
import { ListadoAgendasComponent } from './components/listadoAgendas/listadoAgendas.component';
import { DoctorComponent } from './components/doctor/doctor.component';
import { CitaComponent } from './components/cita/cita.component';
import { CrearCitaComponent } from './components/crearCita/crearCita.component';
import { ReasignarCitaComponent } from './components/reasignarCita/reasignarCita.component';

const routes: Routes = [
  {
    path: 'agenda',
    component: AgendaComponent,
    children: [
      {
        path: 'crear', 
        component: CrearAgendaComponent
      },
      {
        path: 'listar', 
        component: ListadoAgendasComponent
      }
    ]
  },
  {
    path: 'listar-agendas',
    component: AgendaComponent
  },
  {
    path: 'doctores',
    component: DoctorComponent
  },
  {
    path: 'cita',
    component: CitaComponent,
    children: [
      {
        path: 'crear',
        component:CrearCitaComponent
      },
      {
        path: 'reasignar',
        component:ReasignarCitaComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminRoutingModule {}