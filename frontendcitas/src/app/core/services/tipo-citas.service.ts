import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { TipoCita } from '../models/TipoCita';

@Injectable({
  providedIn: 'root'
})
export class TipoCitasService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getTiposCitas(): Observable<TipoCita[]> {
    return this.http.get<TipoCita[]>(`${this.baseUrl}/tipo-citas`);
  }
}
