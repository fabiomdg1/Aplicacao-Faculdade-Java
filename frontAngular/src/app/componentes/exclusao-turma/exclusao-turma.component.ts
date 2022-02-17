import { Turma } from './../../turmaModel';
import { TurmaService } from './../../servicos/turma.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-exclusao-turma',
  templateUrl: './exclusao-turma.component.html',
  styleUrls: ['./exclusao-turma.component.css']
})
export class ExclusaoTurmaComponent implements OnInit {

  //----------------------- Criando a Instância do Objeto Turma ----------------//
  //---------------- Será o parâmetro da função mostrarUmaTurma ----------------//
  turma:Turma = {
    id_turma: '',
    tu_nome : '',
    tu_descricao: ''
  }


  //--------------------------- Injeção de dependências --------------------------//
  //------------No Angular a injeção de dependências é feito no construtor -------//
  //---------- turmaService vai disponibilizar todos seus métodos aqui -----------//
  //---------- O Active route serve para pegar o Id na url como parâmetro --------//
  constructor(private turmaService:TurmaService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.turma.id_turma = this.route.snapshot.paramMap.get('id')
    this.mostrarUmaTurma();
  }

  mostrarUmaTurma(){
    this.turmaService.mostrarUmaTurma(this.turma.id_turma).subscribe((resultado)=>{
      this.turma = resultado;
      console.log(this.turma)
    })
  }

  excluirTurma(){
    this.turmaService.excluirTurma(this.turma.id_turma).subscribe({
      complete: ()=> alert("Turma excluída com sucesso"),
      error: ()=> alert("Esta turma possui alunos associados, não pode ser excluída")
    })

    //----- O Refresh da página ocorre mais rápido que a exclusão do registro no bd -----//
    //----- O setTimeout faz o refresh aguardar para poder mostrar a exclusão -----------//
    setTimeout(() => {
      this.router.navigate(['/turma']);
    }, 500)


  }
}
