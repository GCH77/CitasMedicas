import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Doctor } from '../models/Doctor';
import { PersonaDoctor } from '../models/PersonaDoctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl = environment.baseUrl;
  
  constructor(private http: HttpClient) { }

  getDatosByIdentificacion(tipo: number, identificacion: string): Observable<Doctor>{
    return this.http.get<Doctor>(`${this.baseUrl}/datos/${tipo}/${identificacion}`);
  }

  async saveDoctor(personaDoctor: PersonaDoctor): Promise<PersonaDoctor> {
    try {
      let response = await this.http.post<PersonaDoctor>(`${this.baseUrl}/doctor`, personaDoctor).toPromise();
      return response;
    } catch (error) {
      console.log('Error doctor.service-saveDoctor', error);
    }
  }

}
