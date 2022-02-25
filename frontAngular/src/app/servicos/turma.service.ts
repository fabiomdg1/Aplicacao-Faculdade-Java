import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Turma } from "../turmaModel"


@Injectable({
  providedIn: 'root'
})
export class TurmaService {
  //----- GET e POST serão solicitados e enviados a partir da urlBase -----//
  baseUrl: String = 'http://localhost:8080/faculdade'

  constructor(private http:HttpClient) { }

  //------------------------- Observable ------------------------------//
  //--------- É uma funcionalidade da biblioteca rxjs -----------------//
  //----- Possibilita lidar com transferência de dados assíncrona -----//

  //------------------------------GET---------------------------------//
  //-----------------------mostrarTodasTurmas-------------------------//
  mostrarTodasTurmas():Observable<Turma[]>{
    const url = `${this.baseUrl}/turma`
    return this.http.get<Turma[]>(url)
  }

  //------------------------------GET---------------------------------//
  //------------------------mostrarUmaTurma---------------------------//
  //-------------Este método é usado para excluir turma---------------//
  mostrarUmaTurma(id:string):Observable<Turma>{
    const url = `${this.baseUrl}/turma/${id}`
    return this.http.get<Turma>(url)
  }

  //-----------------------------POST-------------------------------//
  //-------------------------cadastrarTurma-------------------------//
  cadastrarTurma(turma:Turma):Observable<Turma>{
    const url = `${this.baseUrl}/turma`
    return this.http.post<Turma>(url,turma)
  }

  //----------------------------DELETE------------------------------//
  //-------------------------cadastrarTurma-------------------------//
  excluirTurma(id:String):Observable<void>{
    const url = `${this.baseUrl}/turma/${id}`
    return this.http.delete<void>(url)
  }

  //------------------------------PUT-------------------------------//
  //-------------------------cadastrarTurma-------------------------//
  editarTurma(turma:Turma):Observable<void>{
    const url = `${this.baseUrl}/turma/${turma.id_turma}`
    return this.http.put<void>(url,turma)
  }

  atribuirProfessor(turma:Turma, id_turma:String, id_professor:String):Observable<void>{
    const url = `${this.baseUrl}/turma/definirProfessor/${id_turma}/${id_professor}`
    return this.http.put<void>(url,turma)
  }

}
