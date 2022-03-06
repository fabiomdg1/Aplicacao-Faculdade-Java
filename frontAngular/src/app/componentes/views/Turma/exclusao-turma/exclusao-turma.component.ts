import { Turma } from '../../../models/turmaModel';
import { TurmaService } from '../../../../servicos/turma.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-exclusao-turma',
  templateUrl: './exclusao-turma.component.html',
  styleUrls: ['./exclusao-turma.component.css']
})
export class ExclusaoTurmaComponent implements OnInit {turma: Turma = {
  id_turma:'',
  tu_nome:'',
  tu_descricao:''
}

constructor(private turmaService:TurmaService,
            private route: ActivatedRoute,
            private router: Router) { }

ngOnInit(): void {

  this.turma.id_turma = this.route.snapshot.paramMap.get('id')
  this.mostrarUmaTurma()
}

mostrarUmaTurma(){
  this.turmaService.mostrarUmaTurma(this.turma.id_turma).subscribe((resposta)=>{
    this.turma = resposta
    console.log(this.turma)
  })
}

excluirTurma(){
  this.turmaService.excluirTurma(this.turma.id_turma).subscribe({
  complete: () => { alert("Turma excuída com sucesso")
                    this.router.navigate(['/turma'])},
  error: () => { alert("Essa Turma possui professor ou alunos associados, não pode ser deletada")

                this.router.navigate(['/turma']) },
  next: () => { console.log("turma Editada com sucesso")}

  });
}

cancelarExclusao(){
  this.router.navigate(['/turma'])
}
}
