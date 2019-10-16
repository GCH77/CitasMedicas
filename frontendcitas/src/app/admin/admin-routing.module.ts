import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AgendaComponent } from './components/agenda/agenda.component';
import { CrearAgendaComponent } from './components/crearAgenda/crearAgenda.component';
import { ListadoAgendasComponent } from './components/listadoAgendas/listadoAgendas.component';
import { DoctorComponent } from './components/doctor/doctor.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminRoutingModule {}