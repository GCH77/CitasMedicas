import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgendaService } from './services/agenda.service';
import { DoctorService } from './services/doctor.service';
import { EspecialidadService } from './services/especialidad.service';
import { PersonaService } from './services/persona.service';
import { TipoDocumentoService } from './services/tipo-documento.service';


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    AgendaService,
    DoctorService,
    EspecialidadService,
    PersonaService,
    TipoDocumentoService
  ]
})
export class CoreModule { }
