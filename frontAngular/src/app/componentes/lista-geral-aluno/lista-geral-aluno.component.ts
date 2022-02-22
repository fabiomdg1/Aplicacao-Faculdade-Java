import { Router } from '@angular/router';
import { AlunoService } from 'src/app/servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from 'src/app/alunoModel';

@Component({
  selector: 'app-lista-geral-aluno',
  templateUrl: './lista-geral-aluno.component.html',
  styleUrls: ['./lista-geral-aluno.component.css']
})
export class ListaGeralAlunoComponent implements OnInit {

  alunos:Aluno[] = []


  constructor(private alunoService:AlunoService,
              private router:Router) { }

  ngOnInit(): void {
    this.mostrarTodosAlunos()
  }

  mostrarTodosAlunos(){
    this.alunoService.buscarTodosAlunos().subscribe(resultado=>{
      this.alunos = resultado
      console.log(this.alunos)
      })
  }

}
