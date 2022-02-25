import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { HomeComponent } from './componentes/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { ListaTurmaComponent } from './componentes/lista-turma/lista-turma.component';
import { CadastroTurmaComponent } from './componentes/cadastro-turma/cadastro-turma.component';
import { FormsModule } from '@angular/forms';
import { ExclusaoTurmaComponent } from './componentes/exclusao-turma/exclusao-turma.component';
import { EdicaoTurmaComponent } from './componentes/edicao-turma/edicao-turma.component';
import { ListaAlunoComponent } from './componentes/lista-aluno/lista-aluno.component';
import { CadastroAlunoComponent } from './componentes/cadastro-aluno/cadastro-aluno.component';
import { ExclusaoAlunoComponent } from './componentes/exclusao-aluno/exclusao-aluno.component';
import { EdicaoAlunoComponent } from './componentes/edicao-aluno/edicao-aluno.component';
import { ListaGeralAlunoComponent } from './componentes/lista-geral-aluno/lista-geral-aluno.component';
import { ProfessorDaTurmaComponent } from './componentes/professor-da-turma/professor-da-turma.component';
import { ListaProfessorComponent } from './componentes/lista-professor/lista-professor.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ListaTurmaComponent,
    CadastroTurmaComponent,
    ExclusaoTurmaComponent,
    EdicaoTurmaComponent,
    ListaAlunoComponent,
    CadastroAlunoComponent,
    ExclusaoAlunoComponent,
    EdicaoAlunoComponent,
    ListaGeralAlunoComponent,
    ProfessorDaTurmaComponent,
    ListaProfessorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
