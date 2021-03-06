import { Component, OnInit } from '@angular/core';
import { AgendaService } from 'src/app/core/services/agenda.service';
import { Observable } from 'rxjs';
import { faEdit, faTrashAlt, faSave } from '@fortawesome/free-solid-svg-icons';
import { Agenda } from 'src/app/core/models/Agenda';
import { Modal } from 'src/app/core/models/Modal';

@Component({
  selector: 'app-listadoAgendas',
  templateUrl: './listadoAgendas.component.html',
  styleUrls: ['./listadoAgendas.component.css']
})
export class ListadoAgendasComponent implements OnInit {
  //Icons
  faEdit = faEdit;
  faTrashAlt = faTrashAlt;
  faSave = faSave;

  //List
  listAgendas$: Agenda[];
  toEdit: Agenda;
  showBar: boolean;
  sizeItemsPerPage: number;
  totalElements: number;
  totalPages: number;

  constructor(private agendaService: AgendaService) { }

  ngOnInit() {
    this.showBar = true;
    setTimeout(() => {
      this.showBar = false;
      this.getAgendas();
    }, 1000);
  }

  updateAgenda() {
    this.showBar = true;
    this.agendaService.updateAgenda(this.toEdit.id, this.toEdit).subscribe(data => {
      setTimeout(() => {
        this.getAgendas();
        this.showBar = false;
      }, 1000);
    });
    this.dismissModal('#myModal');
  }

  deleteAgenda(idAgenda: number) {
    this.agendaService.deleteAgenda(idAgenda).subscribe(data => {
      this.getAgendas();
    });
    this.dismissModal('#deleteModal');
  }

  showModal(agenda: Agenda, modal: string) {
    this.toEdit = agenda;
    let mdl = new Modal(modal);
    mdl.show();
  }

  dismissModal(modal: string) {
    let mdl = new Modal(modal);
    mdl.close();
  }
  
  getCurrentPage($event) {
    console.log("Change...!", $event);
    this.getAgendas($event, this.sizeItemsPerPage);
  }

  getSize($event) {
    console.log("The size is: ", $event);
    this.sizeItemsPerPage = $event;
    this.getAgendas(0, this.sizeItemsPerPage);
  }

  getAgendas(pageNumber: number = 0, sizePerPage: number = 1) {
    this.agendaService.getAgendasDoctores(pageNumber, sizePerPage).subscribe(data => {
      this.listAgendas$ = data.content;
      this.sizeItemsPerPage = data.size;
      this.totalElements = data.totalElements;
      this.totalPages = data.totalPages;
    });
  }

}
