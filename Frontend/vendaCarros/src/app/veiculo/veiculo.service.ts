import { Veiculo } from './veiculo';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpParams, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  baseUrl: string = 'http://localhost:8080/'

  constructor(private http: HttpClient) { }

  read(): Observable<Veiculo[]> { return this.http.get<Veiculo[]>(this.baseUrl) }

}
