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

  saveAgendaDoctor(agenda: Agenda): Observable<Object>{
    return this.http.post(`${this.baseUrl}/agenda`, agenda);
  }
}
