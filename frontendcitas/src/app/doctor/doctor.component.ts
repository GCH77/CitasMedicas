import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../models/Persona';
import { Doctor } from '../models/Doctor';
import { TipoDocumento } from '../models/tipo-documento';
import { TipoDocumentoService } from './../services/tipo-documento.service';
import { PersonaService } from '../services/persona.service';
import { DoctorService } from '../services/doctor.service';
import { EspecialidadService } from '../services/especialidad.service';
import { faUser, faEnvelope, faIdCard, faStethoscope } from '@fortawesome/free-solid-svg-icons';

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
  doctor: Doctor = new Doctor();
  personaDoctor: Persona = new Persona();
  tipoDocumento: TipoDocumento = new TipoDocumento();

  //data
  tiposDocumentosList: Observable<any>;
  especialidadList: Observable<any>;

  constructor(
    private tiposDocumentosService: TipoDocumentoService,
    private personaService: PersonaService,
    private doctorService: DoctorService,
    private especialidadService: EspecialidadService
  ) { }

  ngOnInit() {
    this.getTiposDocumentos();
    this.getEspecialidades();
  }

  saveDoctor(){
    console.log(this.personaDoctor);
    console.log(this.doctor);
    console.log(this.tipoDocumento);
    let personaCreated: any;
    this.personaDoctor.id_tipo_documento = this.tipoDocumento;
    this.personaService.savePersona(this.personaDoctor)
    .subscribe(res => personaCreated = res);
    this.doctor.id_persona = personaCreated;
    this.doctorService.saveNewDoctor(this.doctor)
    .subscribe(res => console.log(res), error => console.log(error));
    
  }

  getTiposDocumentos() {
    this.tiposDocumentosList = this.tiposDocumentosService.getTiposDocumentos();
  }

  getEspecialidades() {
    this.especialidadList = this.especialidadService.getEspecialidades();
  }

}
