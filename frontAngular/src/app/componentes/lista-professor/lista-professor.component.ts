import { Router } from '@angular/router';
import { ProfessorService } from './../../servicos/professor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-professor',
  templateUrl: './lista-professor.component.html',
  styleUrls: ['./lista-professor.component.css']
})
export class ListaProfessorComponent implements OnInit {

  professores:any = []

  constructor(private professorService: ProfessorService,
              private router:Router) { }

  ngOnInit(): void {

    this.buscarTodosProfessores()
  }



  buscarTodosProfessores(){
    this.professorService.buscarTodosProfessores().subscribe(resultado =>{

      console.log(resultado)

      resultado.forEach((professor: any[]) => {

        let professorComTurma: any ={
          id_professor:'',
          pro_nome:'',
          pro_formacao: '',
          id_turma:'',
          tu_nome:'',
          tu_descricao:''
        }

        professorComTurma.id_professor = professor[0]
        professorComTurma.pro_nome = professor[1]
        professorComTurma.pro_formacao = professor[2]
        if(professor[3] != null){
          professorComTurma.id_turma = professor[3]
          professorComTurma.tu_nome = professor[4]
          professorComTurma.tu_descricao = professor[5]
        }else{
          professorComTurma.id_turma = 0
          professorComTurma.tu_nome = "----"
          professorComTurma.tu_descricao = "----"
        }


        this.professores.push(professorComTurma)

      });


    })

  }

}
