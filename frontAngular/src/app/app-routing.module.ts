import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ListaProfessorComponent } from "./componentes/lista-professor/lista-professor.component";
import { HomeComponent } from "./componentes/Templates/home/home.component";
import { AtribuirTurmaComponent } from "./componentes/views/Aluno/atribuir-turma/atribuir-turma.component";
import { CadastroAlunoComponent } from "./componentes/views/Aluno/cadastro-aluno/cadastro-aluno.component";
import { ListaAlunoComTurmaComponent } from "./componentes/views/Aluno/lista-aluno-com-turma/lista-aluno-com-turma.component";
import { ListaAlunoComponent } from "./componentes/views/Aluno/lista-aluno/lista-aluno.component";
import { ListaAlunosDaTurmaComponent } from "./componentes/views/Aluno/lista-alunos-da-turma/lista-alunos-da-turma.component";
import { AtribuirTurmaAoProfessorComponent } from "./componentes/views/Professor/atribuir-turma-ao-professor/atribuir-turma-ao-professor.component";
import { CadastrarProfessorComponent } from "./componentes/views/Professor/cadastrar-professor/cadastrar-professor.component";
import { ListaCardsProfessorComponent } from "./componentes/views/Professor/lista-cards-professor/lista-cards-professor.component";
import { ProfessorDaTurmaComponent } from "./componentes/views/Professor/professor-da-turma/professor-da-turma.component";
import { CadastroTurmaComponent } from "./componentes/views/Turma/cadastro-turma/cadastro-turma.component";
import { ListaTurmaComponent } from "./componentes/views/Turma/lista-turma/lista-turma.component";

const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"turma", component:ListaTurmaComponent},
  {path:"turma/cadastro", component:CadastroTurmaComponent},
  {path:"turma/delete/:id", component:ListaTurmaComponent},
  {path:"turma/edicao/:id", component:ListaTurmaComponent},
  {path:"turma/aluno/:id", component: ListaAlunoComponent},
  {path:"turma/:id_turma/aluno/cadastro", component:CadastroAlunoComponent},
  {path:"aluno/edicao/:ra_aluno", component:ListaAlunoComponent},
  {path:"aluno/delete/:ra_aluno", component:ListaAlunoComponent},
  {path:"alunosComTurma", component:ListaAlunoComTurmaComponent},
  {path:"professor/cadastro", component:CadastrarProfessorComponent},
  {path:"professorDaTurma/:id_turma", component:ProfessorDaTurmaComponent},
  {path:"professor/listaProfessor", component:ListaProfessorComponent},
  {path:"professor/atribuirTurma/:id_professor", component:AtribuirTurmaAoProfessorComponent},
  {path:"professor/listaCards", component:ListaCardsProfessorComponent},
  //{path:"aluno/cadastro", component:CadastroAlunoComponent},
  {path:"aluno/lista", component:ListaAlunoComponent},
  {path:"aluno/listaDaTurma/:id_turma", component:ListaAlunosDaTurmaComponent},
  {path:"aluno/cadastrar", component:CadastroAlunoComponent},
  {path:"aluno/atribuirTurma/:ra_aluno/:id_turma", component:AtribuirTurmaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
