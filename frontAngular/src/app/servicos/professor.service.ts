import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Professor } from '../professorModel';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  baseUrl: String = 'http://localhost:8080/faculdade'

  constructor(private http:HttpClient) { }

  buscarProfessorDaTurma(id_turma:String):Observable<Professor>{
    const url = `${this.baseUrl}/professor-turma/${id_turma}`;
    return this.http.get<Professor>(url)
  }

  public buscarProfessoresSemTurma():Observable<Professor[]>{

	    const url = `${this.baseUrl}/professorSemTurma`
	    return this.http.get<Professor[]>(url)
	}

  mostrarProfessor(){

  }
}
