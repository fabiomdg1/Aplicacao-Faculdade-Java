import { TurmaService } from './../../servicos/turma.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ProfessorService } from './../../servicos/professor.service';
import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/professorModel';
import { Turma } from 'src/app/turmaModel';

@Component({
  selector: 'app-professor-da-turma',
  templateUrl: './professor-da-turma.component.html',
  styleUrls: ['./professor-da-turma.component.css']
})
export class ProfessorDaTurmaComponent implements OnInit {

  id_turma:any

  turma: Turma = {
    id_turma:'',
    tu_nome:'',
    tu_descricao:''
  }

  professorCadastrado:boolean = false

  // Popular o select, será usado no ngFor
  professoresSemTurma:any =[]


  professorSemTurma:any

  professor:Professor={
    id_professor:'',
    pro_nome:'',
    pro_formacao:'',
    pro_foto:'',
    pro_idade:''
  }



  constructor(private professorService:ProfessorService,
              private route:ActivatedRoute,
              private router:Router,
              private turmaService:TurmaService) { }

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
      //this.professoresSemTurma = resultado
      this.professorSemTurma = resultado

    })
  }

  mostrarProfessor(){
    console.log(this.professoresSemTurma)
    //this.professor = this.professoresSemTurma
    this.professor = this.professorSemTurma
  }

  atribuirProfessor(){
    this.turmaService.mostrarUmaTurma(this.id_turma).subscribe((resultado)=>{
      this.turma = resultado;
    })

    this.turmaService.atribuirProfessor(this.turma, this.turma.id_turma,this.professor.id_professor).subscribe((resultado)=>{
      console.log(resultado)
    })
  }
}