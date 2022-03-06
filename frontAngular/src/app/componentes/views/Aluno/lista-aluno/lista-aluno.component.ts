import { AlunoService } from '../../../../servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute, Router } from '@angular/router';
import { Aluno } from 'src/app/componentes/models/alunoModel';

@Component({
  selector: 'app-lista-aluno',
  templateUrl: './lista-aluno.component.html',
  styleUrls: ['./lista-aluno.component.css']
})
export class ListaAlunoComponent implements OnInit {
  alunos:Aluno[] = []

  constructor(private alunoService: AlunoService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {

    //this.id_turma = this.route.snapshot.paramMap.get('id')!
    this.buscarAlunos()
  }

  buscarAlunos(){

    this.alunoService.buscarTodosAlunos().subscribe(resultado =>{
      this.alunos = resultado
      console.log(this.alunos)
    })


  }

  chamarFormularioCadastro(){
    this.router.navigate(['/aluno/cadastro'])
  }

}
