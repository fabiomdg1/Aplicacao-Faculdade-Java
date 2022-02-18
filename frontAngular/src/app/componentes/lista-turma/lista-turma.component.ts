import { TurmaService } from './../../servicos/turma.service';
import { Component, OnInit } from '@angular/core';
import { Turma } from '../../turmaModel'

@Component({
  selector: 'app-lista-turma',
  templateUrl: './lista-turma.component.html',
  styleUrls: ['./lista-turma.component.css']
})
export class ListaTurmaComponent implements OnInit {

  turmas: Turma[] = []


  constructor(private turmaService: TurmaService) { }

  ngOnInit(): void {
    this.mostrarTodasTurmas()
  }

  mostrarTodasTurmas(){
    this.turmaService.mostrarTodasTurmas().subscribe(resposta =>{
      this.turmas = resposta
    })
  }

}
