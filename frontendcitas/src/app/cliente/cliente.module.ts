import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClienteRoutingModule } from './cliente-routing.module';
import { CitasMedicasComponent } from './components/citas-medicas/citas-medicas.component';
import { NuevaCitaComponent } from './components/nueva-cita/nueva-cita.component';
import { ListarCitasComponent } from './components/listar-citas/listar-citas.component';
import { StepOneComponent } from './components/nueva-cita/components/stepOne/stepOne.component';
import { StepTwoComponent } from './components/nueva-cita/components/stepTwo/stepTwo.component';
import { StepThreeComponent } from './components/nueva-cita/components/stepThree/stepThree.component';
import { StepFourComponent } from './components/nueva-cita/components/stepFour/stepFour.component';


@NgModule({
  imports: [
    CommonModule,
    ClienteRoutingModule,
    FormsModule
  ],
  declarations: [
    CitasMedicasComponent,
    NuevaCitaComponent,
    ListarCitasComponent,
    StepOneComponent,
    StepTwoComponent,
    StepThreeComponent,
    StepFourComponent
  ]
})
export class ClienteModule { }
