import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Turma } from "../componentes/models/turmaModel"


@Injectable({
  providedIn: 'root'
})
export class TurmaService {
  //----- GET e POST serão solicitados e enviados a partir da urlBase -----//
  baseUrl: String = 'http://localhost:8080/faculdade'


  constructor(private http:HttpClient) { }

  mostrarTodasTurmas():Observable<Turma[]>{

    const url = `${this.baseUrl}/turma`

    return this.http.get<Turma[]>(url)
  }

  mostrarTurmasSemProfesor():Observable<Turma[]>{

    const url = `${this.baseUrl}/turmaSemProfessor`

    return this.http.get<Turma[]>(url)
  }

  mostrarUmaTurma(id:string):Observable<Turma>{
    const url = `${this.baseUrl}/turma/${id}`
    return this.http.get<Turma>(url)
  }

  buscarTurmaDoProfessor(id_professor:String):Observable<Turma>{
    //http://localhost:8080/escola/turma/turma-professor/1
    const url = `${this.baseUrl}/turma/turma-professor/${id_professor}`
    return this.http.get<Turma>(url)
  }

  buscarTodasTurmas():Observable<any>{

    const url = `${this.baseUrl}/turma/turma-professor`
    return this.http.get<any>(url)
  }

  cadastroTurma(turma:Turma): Observable<Turma>{
    const url = `${this.baseUrl}/turma`
    return this.http.post<Turma>(url,turma)
  }

  excluirTurma(id:String):Observable<void>{
    const url = `${this.baseUrl}/turma/${id}`
    return this.http.delete<void>(url)

  }

  editarTurma(turma:Turma):Observable<void>{
    const url = `${this.baseUrl}/turma/${turma.id_turma}`
    return this.http.put<void>(url,turma)
  }

  atribuirProfessor(turma:Turma,id_turma:String, id_professor:String):Observable<void>{

    //http://localhost:8080/escola/turma/definirProfessor/3/2

    const url = `${this.baseUrl}/turma/definirProfessor/${id_turma}/${id_professor}`
    return this.http.put<void>(url,turma);

  }

  deixarTurmaSemProfessor(turma:Turma,id_turma:String, id_professor:String):Observable<void>{

    //http://localhost:8080/escola/turma/tirarProfessor/3/2

    const url = `${this.baseUrl}/turma/tirarProfessor/${id_turma}/${id_professor}`
    return this.http.put<void>(url,turma);

  }

}
