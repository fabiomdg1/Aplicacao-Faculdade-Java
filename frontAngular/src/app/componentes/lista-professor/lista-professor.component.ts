import { Professor } from 'src/app/professorModel';
import { Router } from '@angular/router';
import { ProfessorService } from './../../servicos/professor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-professor',
  templateUrl: './lista-professor.component.html',
  styleUrls: ['./lista-professor.component.css']
})
export class ListaProfessorComponent implements OnInit {

  professores:Professor[]=[]

  constructor(private professorService:ProfessorService,
              private router:Router) { }

  ngOnInit(): void {
    this.mostrarTodosProfessores()
  }

  mostrarTodosProfessores(){
    this.professorService.mostrarTodosProfessores().subscribe(resultado=>{
      this.professores = resultado
    })
  }

}
