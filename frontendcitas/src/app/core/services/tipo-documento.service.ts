import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../models/TipoDocumento';

@Injectable({
  providedIn: 'root'
})
export class TipoDocumentoService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getTiposDocumentos(): Observable<TipoDocumento[]>{
    return this.http.get<TipoDocumento[]>(`${this.baseUrl}/tipos-documentos`);
  }
}
