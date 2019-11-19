import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from '../models/Doctor';
import { environment } from 'src/environments/environment';
import { Agenda } from '../models/Agenda';
import { Cita } from '../models/Cita';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getDoctores(tipo: number, fecha: Date): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.baseUrl}/doctores/${tipo}/${fecha}`);
  }

  async getAgendaDoctorDisponible(idDoctor: number): Promise<Agenda> {
    // return this.http.get<Agenda>(`${this.baseUrl}/agenda/${idDoctor}`);
    let response = await this.http.get<Agenda>(`${this.baseUrl}/agenda/${idDoctor}`).toPromise();
    return response;
  }

  saveCitaMedica(citaMedica: Cita): Observable<Cita> {
    return this.http.post<Cita>(`${this.baseUrl}/cita`, citaMedica);
  }

}
