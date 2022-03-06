import { ActivatedRoute, Router } from '@angular/router';
import { AlunoService } from 'src/app/servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from 'src/app/componentes/models/alunoModel';

@Component({
  selector: 'app-exclusao-aluno',
  templateUrl: './exclusao-aluno.component.html',
  styleUrls: ['./exclusao-aluno.component.css']
})
export class ExclusaoAlunoComponent implements OnInit {

  id_turma: string = ''

  aluno:Aluno ={
    ra_aluno: '',
    al_nome:'',
    al_responsavel:'',
    al_cidade:''
  }
  constructor(private alunoService: AlunoService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {

    this.aluno.ra_aluno = this.route.snapshot.paramMap.get('ra_aluno')
    this.buscarUmAluno()
  }

  buscarUmAluno(){
    this.alunoService.buscarUmAluno(this.aluno.ra_aluno).subscribe((resultado)=>{
      this.aluno = resultado
    })
  }

  cancelarExclusao(){
    this.router.navigate(['/alunosComTurma'])
  }

  excluirAluno(){
    this.alunoService.excluirAluno(this.aluno.ra_aluno).subscribe({
      complete: () => { alert("Aluno excuído com sucesso")
                        this.router.navigate(['/alunosComTurma'])},
      error: () => { alert("Erro ao excluir o aluno")
                    this.router.navigate(['/alunosComTurma']) },
      next: () => { console.log("aluno excluido com sucesso")}

      });
  }


}
