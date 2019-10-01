import { TipoDocumentoService } from './../services/tipo-documento.service';
import { Component, OnInit } from '@angular/core';
import { faFingerprint, faSearch, faSave } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs';
import { DoctorService } from '../services/doctor.service';
import { Agenda } from '../models/Agenda';
import { AgendaService } from '../services/agenda.service';
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
  tiposDocumentosList: Observable<any>;
  doctor: Observable<any>
  
  constructor(
    private tiposDocumentosService: TipoDocumentoService,
    private doctorService: DoctorService,
    private agendaService: AgendaService
    ) { }

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
    this.agendaService.saveAgendaDoctor(this.agendaDoctor);
  }

  getTiposDocumentos() {
    this.tiposDocumentosList = this.tiposDocumentosService.getTiposDocumentos();
  }

}
