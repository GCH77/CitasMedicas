import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Especialidad } from '../models/Especialidad';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {
  private baseUrl = environment.baseUrl;

constructor(private http: HttpClient) { }

getEspecialidades(): Observable<Especialidad[]>{
  return this.http.get<Especialidad[]>(`${this.baseUrl}/especialidad-list`);
}

}
