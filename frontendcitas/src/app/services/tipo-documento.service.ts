import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipoDocumentoService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getTiposDocumentos(): Observable<any>{
    return this.http.get(`${this.baseUrl}/tipos-documentos`);
  }
}
