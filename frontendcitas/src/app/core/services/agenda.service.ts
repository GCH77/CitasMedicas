import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Agenda } from '../models/Agenda';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgendaService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getAgendasDoctores(): Observable<Agenda[]> {
    return this.http.get<Agenda[]>(`${this.baseUrl}/agendas`);
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
