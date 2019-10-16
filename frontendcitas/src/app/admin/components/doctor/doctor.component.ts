import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from './../../../core/models/Persona';
import { Doctor } from './../../../core/models/Doctor';
import { TipoDocumentoService } from './../../../core/services/tipo-documento.service';
import { PersonaService } from './../../../core/services/persona.service';
import { DoctorService } from './../../../core/services/doctor.service';
import { EspecialidadService } from './../../../core/services/especialidad.service';
import { faUser, faEnvelope, faIdCard, faStethoscope } from '@fortawesome/free-solid-svg-icons';
import { TipoDocumento } from './../../../core/models/TipoDocumento';
import { Especialidad } from 'src/app/core/models/Especialidad';
import { PersonaDoctor } from 'src/app/core/models/PersonaDoctor';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  //Icons
  faUser = faUser; 
  faIdCard = faIdCard;
  faEnvelope = faEnvelope;
  faStethoscope = faStethoscope;

  //Form var
  doctor: Doctor;
  personaDoctor: Persona;
  selectedTipoDoc: TipoDocumento;
  bothInfo: PersonaDoctor;

  //data
  tiposDocumentosList$: Observable<TipoDocumento[]>;
  especialidadList$: Observable<Especialidad[]>;

  constructor(
    private tiposDocumentosService: TipoDocumentoService,
    private doctorService: DoctorService,
    private especialidadService: EspecialidadService
  ) {
    this.doctor = new Doctor();
    this.personaDoctor = new Persona();
    this.bothInfo = new PersonaDoctor();
   }

  ngOnInit() {
    this.getTiposDocumentos();
    this.getEspecialidades();
  }

  async saveDoctor() {
    this.bothInfo.persona = this.personaDoctor;
    this.bothInfo.doctor = this.doctor;
    await this.doctorService.saveDoctor(this.bothInfo).then(data => {
      console.log("DATA");
      console.log(data);
    });
  }

  getTiposDocumentos() {
    this.tiposDocumentosList$ = this.tiposDocumentosService.getTiposDocumentos();
  }

  getEspecialidades() {
    this.especialidadList$ = this.especialidadService.getEspecialidades();
  }

}
