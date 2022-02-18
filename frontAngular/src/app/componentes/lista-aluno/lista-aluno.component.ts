import { AlunoService } from './../../servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute, Router } from '@angular/router';
import { Aluno } from 'src/app/alunoModel';

@Component({
  selector: 'app-lista-aluno',
  templateUrl: './lista-aluno.component.html',
  styleUrls: ['./lista-aluno.component.css']
})
export class ListaAlunoComponent implements OnInit {

  id_turma:string =''
  alunos:Aluno[] = []

  constructor(private alunoService: AlunoService,
              private route:ActivatedRoute,
              private router:Router) {

              }

  ngOnInit(): void {
    this.id_turma = this.route.snapshot.paramMap.get('id_turma')!
    this.buscarAlunoTurma()
  }

  buscarAlunoTurma(){
    this.alunoService.buscarAlunoTurma(this.id_turma).subscribe((resultado)=>{
      this.alunos = resultado;
    })
  }

}
