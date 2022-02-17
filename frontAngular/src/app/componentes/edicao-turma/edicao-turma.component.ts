import { ActivatedRoute, Router } from '@angular/router';
import { TurmaService } from './../../servicos/turma.service';
import { Component, OnInit } from '@angular/core';
import { Turma } from 'src/app/turmaModel';


@Component({
  selector: 'app-edicao-turma',
  templateUrl: './edicao-turma.component.html',
  styleUrls: ['./edicao-turma.component.css']
})
export class EdicaoTurmaComponent implements OnInit {

  turma:Turma = {
    id_turma:'',
    tu_nome:'',
    tu_descricao:''
  }
  constructor(private turmaService: TurmaService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.turma.id_turma = this.route.snapshot.paramMap.get('id')
    this.mostrarUmaTurma()
  }

  mostrarUmaTurma(){
    this.turmaService.mostrarUmaTurma(this.turma.id_turma).subscribe((resultado)=>{
      this.turma = resultado
    })
  }

  editarTurma(){
    this.turmaService.editarTurma(this.turma).subscribe({
      complete: () => alert("Turma editada com sucesso"),
      error: () => alert("Erro: Turma não pode ser editada")
    })

    //----- O Refresh da página ocorre mais rápido que a exclusão do registro no bd -----//
    //----- O setTimeout faz o refresh aguardar para poder mostrar a exclusão -----------//
    setTimeout(() => {
      this.router.navigate(['/turma']);
    }, 500)

  }

}
