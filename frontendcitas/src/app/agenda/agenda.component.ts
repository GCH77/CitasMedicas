import { TipoDocumentoService } from './../services/tipo-documento.service';
import { Component, OnInit } from '@angular/core';
import { faFingerprint, faSearch, faSave } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs';
import { DoctorService } from '../services/doctor.service';
import { Agenda } from '../models/Agenda';
import { AgendaService } from '../services/agenda.service';
import { Doctor } from '../models/Doctor';
@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.scss']
})
export class AgendaComponent implements OnInit {
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
  tiposDocumentosList: Observable<any>;
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
    // console.log("GET");
    this.showBar = !this.showBar;
    setTimeout(() => {
      this.doctorService.getDatosByIdentificacion(this.tipoDocumento, this.numeroDocumento)
        .subscribe(res => {
          this.doctor = res ? res : '';
          this.showBar = !this.showBar;
        });
    }, 800);
    // console.log(this.doctor);
  }

  saveDisponibilidad(){
    this.agendaDoctor.id_doctor = this.doctor;
    this.agendaService.saveAgendaDoctor(this.agendaDoctor)
      .subscribe(res => {
        if (res.hasOwnProperty('id')) {
          this.resetValues();
          this.dismissSuccess();
          setTimeout(() => {
            this.dismissSuccess();
          }, 2000);
        }else{
          this.resetValues();
          this.dismissDanger();
          setTimeout(() => {
            this.dismissDanger();
          }, 2000);
        }
      });
  }

  getTiposDocumentos() {
    this.tiposDocumentosList = this.tiposDocumentosService.getTiposDocumentos();
  }

  dismissSuccess(){
    this.showSuccess = !this.showSuccess;
  }

  dismissDanger(){
    this.showDanger = !this.showDanger;
  }

  resetValues(){
    this.tipoDocumento = null;
    this.numeroDocumento = null;
    this.doctor = null;
  }

}
