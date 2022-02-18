import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Aluno } from 'src/app/alunoModel';
import { AlunoService } from 'src/app/servicos/aluno.service';

@Component({
  selector: 'app-cadastro-aluno',
  templateUrl: './cadastro-aluno.component.html',
  styleUrls: ['./cadastro-aluno.component.css']
})
export class CadastroAlunoComponent implements OnInit {

  id_turma: string = ''
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
    // id_turma precisa estar com o mesmo nome colocado na rota
    this.id_turma = this.route.snapshot.paramMap.get('id_turma')!
  }

  cadastrarAluno(){
    this.alunoService.cadastrarAluno(this.aluno, this.id_turma).subscribe({
      complete: () => {alert("Aluno cadastrado na turma")
                      this.router.navigate([`/alunoTurma/${this.id_turma}`])},

      error: () => {alert("Erro no cadastro do aluno")
                  this.router.navigate([`/alunoTurma/${this.id_turma}`])},

      next:() => {console.log("Aluno cadastrado")}
    })
  }

}
