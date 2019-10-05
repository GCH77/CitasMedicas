import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {
  private baseUrl = environment.baseUrl;

constructor(private http: HttpClient) { }

getEspecialidades(): Observable<any>{
  return this.http.get(`${this.baseUrl}/especialidad-list`);
}

}
