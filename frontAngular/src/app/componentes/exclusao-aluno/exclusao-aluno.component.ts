import { ActivatedRoute, Router } from '@angular/router';
import { AlunoService } from 'src/app/servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from 'src/app/alunoModel';

@Component({
  selector: 'app-exclusao-aluno',
  templateUrl: './exclusao-aluno.component.html',
  styleUrls: ['./exclusao-aluno.component.css']
})
export class ExclusaoAlunoComponent implements OnInit {

  id_turma: String=''

  aluno:Aluno = {
    ra_aluno:'',
    al_nome:'',
    al_responsavel:'',
    al_cidade:''
  }

  constructor(private alunoService:AlunoService,
              private route:ActivatedRoute,
              private router:Router) {
  }

  ngOnInit(): void {
    this.id_turma = this.route.snapshot.paramMap.get("id_turma")!
    this.aluno.ra_aluno = this.route.snapshot.paramMap.get("ra_aluno")
    this.buscarUmAluno()
  }

  buscarUmAluno(){
    this.alunoService.buscarUmAluno(this.aluno.ra_aluno).subscribe((resultado)=>{
      this.aluno = resultado
    })
  }

  deleteAluno(){
    this.alunoService.deleteAluno(this.aluno.ra_aluno).subscribe({
      next: () => {alert("Aluno deletado com sucesso")},

      error: () => {alert("Não foi possível deletar este aluno")
      this.router.navigate([`/alunoTurma/${this.id_turma}`])
      },

      complete: () => {this.router.navigate([`/alunoTurma/${this.id_turma}`])}

      }
    )
  }

}
