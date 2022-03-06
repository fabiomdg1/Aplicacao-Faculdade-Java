import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Aluno } from 'src/app/componentes/models/alunoModel';
import { AlunoService } from 'src/app/servicos/aluno.service';
import { TurmaService } from 'src/app/servicos/turma.service';

@Component({
  selector: 'app-cadastro-aluno',
  templateUrl: './cadastro-aluno.component.html',
  styleUrls: ['./cadastro-aluno.component.css']
})
export class CadastroAlunoComponent implements OnInit {

  id_turma: string = ''
  turmas:any
  turmaEscolhida: any


  aluno:Aluno ={
    ra_aluno: '',
    al_nome:'',
    al_responsavel:'',
    al_cidade:''

  }
  constructor(private alunoService: AlunoService,
              private turmaService:TurmaService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {

    this.id_turma = this.route.snapshot.paramMap.get('id_turma')!
    this.mostrarTurmasParaAtribuicao()
  }

  confirmarCadastroAluno(){
    this.alunoService.cadastrarAluno(this.aluno).subscribe({
    complete: () => { alert("Aluno cadastrado com sucessoxxxx")
                      this.router.navigate(['/alunosComTurma'])
                    },
    error: () => { alert("Aluno não cadastrado")
                      this.router.navigate(['/alunosComTurma'])
                    },
    next: () => { console.log("Aluno cadastrado com sucesso")}

    });

  }

  cancelarCadastro(){
    this.router.navigate([`/aluno`])
  }

  mostrarTurmasParaAtribuicao(){
    this.turmaService.mostrarTodasTurmas().subscribe(resultado =>{
      this.turmas = resultado
    })
  }

  escolherTurma(){
    console.log(this.turmaEscolhida)
  }
}
