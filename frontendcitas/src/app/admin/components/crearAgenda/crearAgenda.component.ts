import { Component, OnInit } from '@angular/core';
import { TipoDocumentoService } from '../../../core/services/tipo-documento.service';
import { faFingerprint, faSearch, faSave } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs';
import { DoctorService } from '../../../core/services/doctor.service';
import { Agenda } from './../../../core/models/Agenda';
import { AgendaService } from '../../../core/services/agenda.service';
import { Doctor } from '../../../core/models/Doctor';
import { TipoDocumento } from 'src/app/core/models/TipoDocumento';

@Component({
  selector: 'app-crearAgenda',
  templateUrl: './crearAgenda.component.html',
  styleUrls: ['./crearAgenda.component.css']
})
export class CrearAgendaComponent implements OnInit {
  //Icons
  faFingerprint = faFingerprint;
  faSearch = faSearch;
  faSave = faSave;

  //Form var
  tipoDocumento: number;
  numeroDocumento: string;
  agendaDoctor: Agenda = new Agenda();

  //data
  showBar: boolean;
  showSuccess: boolean;
  showDanger: boolean;
  tiposDocumentosList$: Observable<TipoDocumento[]>;
  doctor: Doctor;
  
  constructor(
    private tiposDocumentosService: TipoDocumentoService,
    private doctorService: DoctorService,
    private agendaService: AgendaService
    ) { 
      this.showSuccess = false;
      this.showDanger = false;
      this.agendaDoctor.duracion_cita = 30;
    }

  ngOnInit() {
    this.getTiposDocumentos();
  }

  searchDoctor() {
    this.dismissShowBar(true);
    setTimeout(() => {
      this.doctorService.getDatosByIdentificacion(this.tipoDocumento, this.numeroDocumento)
        .subscribe(res => {
          this.doctor = res ? res : null;
          this.dismissShowBar(false);
        });
    }, 800);
  }

  saveDisponibilidad(){
    this.dismissShowBar(true);
    this.agendaDoctor.id_doctor = this.doctor;
    this.agendaService.saveAgendaDoctor(this.agendaDoctor)
      .subscribe(res => {
        if (res.hasOwnProperty('id')) {
          this.resetValues();
          this.dismissSuccess(true);
          setTimeout(() => {
            this.dismissSuccess(false);
          }, 2000);
        }else{
          this.resetValues();
          this.dismissDanger(true);
          setTimeout(() => {
            this.dismissDanger(false);
          }, 2000);
        }
      });
  }

  getTiposDocumentos() {
    this.tiposDocumentosList$ = this.tiposDocumentosService.getTiposDocumentos();
  }

  dismissSuccess(state: boolean) {
    this.showSuccess = state;
  }

  dismissDanger(state: boolean) {
    this.showDanger = state;
  }

  dismissShowBar(state: boolean) {
    this.showBar = state;
  }

  resetValues(){
    this.tipoDocumento = null;
    this.numeroDocumento = null;
    this.doctor = null;
  }

}
