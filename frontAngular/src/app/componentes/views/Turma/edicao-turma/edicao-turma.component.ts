import { ActivatedRoute, Router } from '@angular/router';
import { TurmaService } from '../../../../servicos/turma.service';
import { Component, OnInit } from '@angular/core';
import { Turma } from 'src/app/componentes/models/turmaModel';


@Component({
  selector: 'app-edicao-turma',
  templateUrl: './edicao-turma.component.html',
  styleUrls: ['./edicao-turma.component.css']
})
export class EdicaoTurmaComponent implements OnInit {

  turma: Turma = {
    id_turma:'',
    tu_nome:'',
    tu_descricao:''
  }
  constructor(private turmaService:TurmaService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.turma.id_turma = this.route.snapshot.paramMap.get('id')
    this.mostrarUmaTurma()
  }

  mostrarUmaTurma(){
    this.turmaService.mostrarUmaTurma(this.turma.id_turma).subscribe((resposta)=>{
      this.turma = resposta
      console.log(this.turma)
    })
  }


  editarTurma(){
    this.turmaService.editarTurma(this.turma).subscribe({
    complete: () => { alert("Turma editada com sucesso")
                      this.router.navigate(['/turma'])},
    error: () => { alert("Turma editada com sucesso")
                  this.router.navigate(['/turma']) },
    next: () => { console.log("turma Editada com sucesso")}

    });

  }

  cancelarEdicao(){
    this.router.navigate(['/turma'])
  }

}
