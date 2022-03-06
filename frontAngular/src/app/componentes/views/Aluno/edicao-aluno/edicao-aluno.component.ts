import { ActivatedRoute, Router } from '@angular/router';
import { AlunoService } from 'src/app/servicos/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from 'src/app/componentes/models/alunoModel';

@Component({
  selector: 'app-edicao-aluno',
  templateUrl: './edicao-aluno.component.html',
  styleUrls: ['./edicao-aluno.component.css']
})
export class EdicaoAlunoComponent implements OnInit {


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

  editarAluno(){
    this.alunoService.editarAluno(this.aluno,this.aluno.ra_aluno).subscribe({
    complete: () => { alert("Aluno editado com sucesso")
                      this.router.navigate([`/alunosComTurma`])},
    error: () => { alert("Aluno não editado")
                      this.router.navigate(['/alunosComTurma']) },
    next: () => { console.log("Aluno cadastrado com sucesso")}

    });

  }

  cancelarEdicao(){
    this.router.navigate(['/alunosComTurma'])
  }

}
