import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaGeralAlunoComponent } from './lista-geral-aluno.component';

describe('ListaGeralAlunoComponent', () => {
  let component: ListaGeralAlunoComponent;
  let fixture: ComponentFixture<ListaGeralAlunoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaGeralAlunoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaGeralAlunoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
