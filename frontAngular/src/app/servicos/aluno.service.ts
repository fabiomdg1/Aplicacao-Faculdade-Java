import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aluno } from '../alunoModel';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  baseUrl:string = 'http://localhost:8080/faculdade'

  constructor(private http:HttpClient) { }

  buscarAlunoTurma(id_turma:string):Observable<Aluno[]>{
    const url = `${this.baseUrl}/aluno/busca-turma/${id_turma}`
    return this.http.get<Aluno[]>(url);
  }

  cadastrarAluno(aluno:Aluno, id_turma:string):Observable<Aluno>{
		const url = `${this.baseUrl}/aluno?turma=${id_turma}`
    return this.http.post<Aluno>(url,aluno)
	}

  buscarUmAluno(ra_aluno:string):Observable<Aluno>{
    const url = `${this.baseUrl}/aluno/${ra_aluno}`
    return this.http.get<Aluno>(url)
  }

  deleteAluno(ra_aluno:string):Observable<Aluno>{
    const url = `${this.baseUrl}/aluno/${ra_aluno}`
    return this.http.delete<Aluno>(url)
  }

}