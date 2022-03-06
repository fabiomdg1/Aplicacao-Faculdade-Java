import { SafePipe } from './componentes/pipe/safe-pipe.pipe';
import { ListaCardsProfessorComponent } from './componentes/views/Professor/lista-cards-professor/lista-cards-professor.component';
import { AtribuirTurmaAoProfessorComponent } from './componentes/views/Professor/atribuir-turma-ao-professor/atribuir-turma-ao-professor.component';
import { AtribuirTurmaComponent } from './componentes/views/Aluno/atribuir-turma/atribuir-turma.component';
import { ListaAlunosDaTurmaComponent } from './componentes/views/Aluno/lista-alunos-da-turma/lista-alunos-da-turma.component';
import { ListaAlunoComTurmaComponent } from './componentes/views/Aluno/lista-aluno-com-turma/lista-aluno-com-turma.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/Templates/header/header.component';
import { FooterComponent } from './componentes/Templates/footer/footer.component';
import { HomeComponent } from './componentes/Templates/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { ListaTurmaComponent } from './componentes/views/Turma/lista-turma/lista-turma.component';
import { CadastroTurmaComponent } from './componentes/views/Turma/cadastro-turma/cadastro-turma.component';
import { FormsModule } from '@angular/forms';
import { ExclusaoTurmaComponent } from './componentes/views/Turma/exclusao-turma/exclusao-turma.component';
import { EdicaoTurmaComponent } from './componentes/views/Turma/edicao-turma/edicao-turma.component';
import { ListaAlunoComponent } from './componentes/views/Aluno/lista-aluno/lista-aluno.component';
import { CadastroAlunoComponent } from './componentes/views/Aluno/cadastro-aluno/cadastro-aluno.component';
import { ExclusaoAlunoComponent } from './componentes/views/Aluno/exclusao-aluno/exclusao-aluno.component';
import { EdicaoAlunoComponent } from './componentes/views/Aluno/edicao-aluno/edicao-aluno.component';
import { ListaGeralAlunoComponent } from './componentes/views/Aluno/lista-geral-aluno/lista-geral-aluno.component';
import { ProfessorDaTurmaComponent } from './componentes/views/Professor/professor-da-turma/professor-da-turma.component';
import { ListaProfessorComponent } from './componentes/lista-professor/lista-professor.component';
import { CadastrarProfessorComponent } from './componentes/views/Professor/cadastrar-professor/cadastrar-professor.component';

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
    ListaProfessorComponent,
    ListaAlunoComTurmaComponent,
    ListaAlunosDaTurmaComponent,
    AtribuirTurmaComponent,
    AtribuirTurmaAoProfessorComponent,
    ListaCardsProfessorComponent,
    SafePipe,
    CadastrarProfessorComponent






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
