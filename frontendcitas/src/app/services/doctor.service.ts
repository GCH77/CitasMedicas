import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl = environment.baseUrl;
  
  constructor(private http: HttpClient) { }

  getDatosByIdentificacion(tipo: number, identificacion: string): Observable<any>{
    console.log("SERVICE");
    return this.http.get(`${this.baseUrl}/datos/${tipo}/${identificacion}`);
  }

}
