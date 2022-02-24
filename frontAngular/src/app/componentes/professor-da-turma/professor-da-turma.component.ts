import { Router, ActivatedRoute } from '@angular/router';
import { ProfessorService } from './../../servicos/professor.service';
import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/professorModel';

@Component({
  selector: 'app-professor-da-turma',
  templateUrl: './professor-da-turma.component.html',
  styleUrls: ['./professor-da-turma.component.css']
})
export class ProfessorDaTurmaComponent implements OnInit {

  id_turma:any
  professorCadastrado:boolean = false

  professoresSemTurma:any

  id_professorSemTurma:any

  professor:Professor={
    id_professor:'',
    pro_nome:'',
    pro_formacao:'',
    pro_foto:''
  }

  constructor(private professorService:ProfessorService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.id_turma = this.route.snapshot.paramMap.get('id_turma')
    this.buscarProfessorDaTurma()
    this.buscarProfessoresSemTurma()
  }

  buscarProfessorDaTurma(){
    this.professorService.buscarProfessorDaTurma(this.id_turma).subscribe((resultado)=>{

      if(resultado == undefined){
        alert("Para esta turma não há professor definido.")
        this.professorCadastrado = false
      }else{
        this.professor = resultado
        this.professorCadastrado = true
      }
    })
  }

  buscarProfessoresSemTurma(){
    this.professorService.buscarProfessoresSemTurma().subscribe((resultado)=>{
      console.log(this.professoresSemTurma = resultado)
      this.professoresSemTurma = resultado

    })
  }

  mostrarProfessor(){
    console.log(this.id_professorSemTurma)
  }

}
