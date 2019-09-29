import { TipoDocumentoService } from './../services/tipo-documento.service';
import { Component, OnInit } from '@angular/core';
import { faFingerprint, faSearch } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../models/tipo-documento';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.scss']
})
export class AgendaComponent implements OnInit {
  //Icons
  faFingerprint = faFingerprint;
  faSearch = faSearch;

  //Form var
  tipoDocumento: number;
  numeroDocumento: string;

  //data
  tiposDocumentosList: Observable<any>;
  
  constructor(private tiposDocumentosService: TipoDocumentoService) { }

  ngOnInit() {
    this.getTiposDocumentos();
  }

  searchDoctor() {
    alert(`Consultando tipo: ${+this.tipoDocumento}, numero: ${this.numeroDocumento}`);
  }

  getTiposDocumentos() {
    this.tiposDocumentosList = this.tiposDocumentosService.getTiposDocumentos();
  }

}
