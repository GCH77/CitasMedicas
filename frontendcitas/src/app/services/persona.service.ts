import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Persona } from '../models/Persona';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  savePersona(persona: Persona): Observable<Object>{
    return this.http.post(`${this.baseUrl}/personas`, persona);
  }

}