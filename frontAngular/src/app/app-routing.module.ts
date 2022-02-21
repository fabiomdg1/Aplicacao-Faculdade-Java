import { ListaGeralAlunoComponent } from './componentes/lista-geral-aluno/lista-geral-aluno.component';
import { EdicaoAlunoComponent } from './componentes/edicao-aluno/edicao-aluno.component';
import { ExclusaoAlunoComponent } from './componentes/exclusao-aluno/exclusao-aluno.component';
import { CadastroAlunoComponent } from './componentes/cadastro-aluno/cadastro-aluno.component';
import { ListaAlunoComponent } from './componentes/lista-aluno/lista-aluno.component';
import { EdicaoTurmaComponent } from './componentes/edicao-turma/edicao-turma.component';
import { ExclusaoTurmaComponent } from './componentes/exclusao-turma/exclusao-turma.component';
import { CadastroTurmaComponent } from './componentes/cadastro-turma/cadastro-turma.component';
import { ListaTurmaComponent } from './componentes/lista-turma/lista-turma.component';
import { HomeComponent } from './componentes/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: "", redirectTo: "/home", pathMatch: 'full' },
  {path:"home", component:HomeComponent},
  {path:"turma", component:ListaTurmaComponent},
  {path: "cadastroTurma", component:CadastroTurmaComponent},
  {path: "exclusaoTurma/:id", component:ExclusaoTurmaComponent},
  {path: "edicaoTurma/:id", component:EdicaoTurmaComponent},
  {path: "alunoTurma/:id_turma", component:ListaAlunoComponent},
  {path: "alunoCadastro/:id_turma", component:CadastroAlunoComponent},
  {path: "alunoExclusao/:ra_aluno/:id_turma", component:ExclusaoAlunoComponent},
  {path: "alunoEdicao/:ra_aluno/:id_turma", component:EdicaoAlunoComponent},
  {path: "listaGeralAlunos", component: ListaGeralAlunoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
