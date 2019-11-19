import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CitasMedicasComponent } from './components/citas-medicas/citas-medicas.component';
import { NuevaCitaComponent } from './components/nueva-cita/nueva-cita.component';
import { ListarCitasComponent } from './components/listar-citas/listar-citas.component';
import { StepOneComponent } from './components/nueva-cita/components/stepOne/stepOne.component';
import { StepTwoComponent } from './components/nueva-cita/components/stepTwo/stepTwo.component';
import { StepThreeComponent } from './components/nueva-cita/components/stepThree/stepThree.component';
import { StepFourComponent } from './components/nueva-cita/components/stepFour/stepFour.component';


const routes: Routes = [
  {
    path: 'citas-medicas',
    component: CitasMedicasComponent,
    children: [
      {
        path: 'nueva', 
        component: NuevaCitaComponent,
        children: [
          {
            path: '1', 
            component: StepOneComponent
          },
          {
            path: '2', 
            component: StepTwoComponent
          },
          {
            path: '3', 
            component: StepThreeComponent
          },
          {
            path: '4', 
            component: StepFourComponent
          }
        ]
      },
      {
        path: 'listar', 
        component: ListarCitasComponent
      }
    ]
  },
  /* {
    path: 'listar-agendas',
    component: AgendaComponent
  },
  {
    path: 'doctores',
    component: DoctorComponent
  } */
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class ClienteRoutingModule {}