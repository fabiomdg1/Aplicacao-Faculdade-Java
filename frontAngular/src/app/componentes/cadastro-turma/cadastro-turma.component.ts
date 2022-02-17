import { TurmaService } from './../../servicos/turma.service';
import { Component, OnInit } from '@angular/core';
import { Turma } from 'src/app/turmaModel';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-turma',
  templateUrl: './cadastro-turma.component.html',
  styleUrls: ['./cadastro-turma.component.css']
})
export class CadastroTurmaComponent implements OnInit {

  //----- Criando objeto turma para servir de parâmetro na função cadastrarTurma -----//
  turma:Turma = {
    tu_nome: '',
    tu_descricao: ''
  }

  //--------------------------- Injeção de dependências --------------------------//
  //------------No Angular a injeção de dependências é feito no construtor -------//
  //---------- turmaService vai disponibilizar todos seus métodos aqui -----------//
  constructor(private turmaService:TurmaService,
              private router: Router) { }

  ngOnInit(): void {
  }

  //------------------------------ Cadastrar Turma --------------------------------//
  cadastrarTurma(){
    this.turmaService.cadastrarTurma(this.turma).subscribe((resultado)=>{
      alert("Turma cadastrada com sucesso")
      this.router.navigate(['/turma'])
    })
  }

}
