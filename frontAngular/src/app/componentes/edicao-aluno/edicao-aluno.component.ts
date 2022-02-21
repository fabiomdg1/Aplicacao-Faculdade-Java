import { ActivatedRoute, Router } from '@angular/router';
import { AlunoService } from 'src/app/servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from 'src/app/alunoModel';

@Component({
  selector: 'app-edicao-aluno',
  templateUrl: './edicao-aluno.component.html',
  styleUrls: ['./edicao-aluno.component.css']
})
export class EdicaoAlunoComponent implements OnInit {

  id_turma: any =''

  aluno:Aluno={
    ra_aluno:'',
    al_nome:'',
    al_responsavel:'',
    al_cidade:''
  }
  constructor(private alunoService:AlunoService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.aluno.ra_aluno = this.route.snapshot.paramMap.get('ra_aluno')
    this.id_turma = this.route.snapshot.paramMap.get('id_turma')!
    this.buscarUmAluno()
  }

    buscarUmAluno(){
      this.alunoService.buscarUmAluno(this.aluno.ra_aluno).subscribe((resultado)=>{
        this.aluno = resultado
      })
    }

    editarAluno(){
      this.alunoService.editarAluno(this.aluno, this.aluno.al_cidade,this.id_turma).subscribe({
        complete:()=>{alert("Aluno editado com sucesso")
        this.router.navigate([`alunoTurma/${this.id_turma}`])},

        error:()=>{alert("Erro ao editar aluno")
        this.router.navigate([`alunoTurma/${this.id_turma}`])}
      })
    }

    trocarTurma(){
      this.id_turma = prompt("Para qual turma deseja transferir o aluno ?", "id_turma")
      this.alunoService.editarAluno(this.aluno,this.aluno.ra_aluno,this.id_turma).subscribe({
        complete:()=>{alert("Aluno transferido com sucesso")
        this.router.navigate([`alunoTurma/${this.id_turma}`])},

        error:()=>{alert("Erro ao transferir aluno")
        //this.router.navigate([`alunoTurma/${this.id_turma}`])
      }
      })

    }


}
