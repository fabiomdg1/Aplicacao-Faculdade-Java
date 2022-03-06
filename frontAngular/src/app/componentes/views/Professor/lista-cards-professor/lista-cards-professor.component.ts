import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Professor } from 'src/app/componentes/models/professorModel';
import { ProfessorService } from 'src/app/servicos/professor.service';

@Component({
  selector: 'app-lista-cards-professor',
  templateUrl: './lista-cards-professor.component.html',
  styleUrls: ['./lista-cards-professor.component.css']
})
export class ListaCardsProfessorComponent implements OnInit {


  professores:Professor[] = []

  constructor( private professorService:ProfessorService,
                private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.buscarTodosProfessores()
  }


  buscarTodosProfessores(){

    this.professorService.buscarTodosProfessores2().subscribe(resultado =>{
      this.professores = resultado
      console.log(resultado[0].pro_foto)
    })


  }
}
