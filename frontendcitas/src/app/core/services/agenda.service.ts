import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Agenda } from '../models/Agenda';
import { Observable } from 'rxjs';
import { Pagination } from '../models/Pagination';

@Injectable({
  providedIn: 'root'
})
export class AgendaService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getAgendasDoctores(pageNumber: number, sizePerPage: number): Observable<Pagination> {
    return this.http.get<Pagination>(`${this.baseUrl}/agendas?page=${pageNumber}&size=${sizePerPage}`);
  }

  saveAgendaDoctor(agenda: Agenda): Observable<Agenda> {
    return this.http.post<Agenda>(`${this.baseUrl}/agenda`, agenda);
  }

  updateAgenda(idAgenda: number, agenda: Agenda): Observable<Agenda> {
    return this.http.put<Agenda>(`${this.baseUrl}/agenda/${idAgenda}`, agenda);
  }

  deleteAgenda(idAgenda: number) {
    return this.http.delete(`${this.baseUrl}/agenda/${idAgenda}`);
  }
}
