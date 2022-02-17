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
  {path: "edicaoTurma/:id", component:EdicaoTurmaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
