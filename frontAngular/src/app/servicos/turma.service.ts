import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Turma } from "../turmaModel"

@Injectable({
  providedIn: 'root'
})
export class TurmaService {

  baseUrl: String = 'http://localhost:8080/faculdade'

  constructor(private http:HttpClient) { }

  mostrarTodasTurmas():Observable<Turma[]>{
    const url = `${this.baseUrl}/turma`
    return this.http.get<Turma[]>(url)
  }

}
