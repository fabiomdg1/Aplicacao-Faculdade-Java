import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorDaTurmaComponent } from './professor-da-turma.component';

describe('ProfessorDaTurmaComponent', () => {
  let component: ProfessorDaTurmaComponent;
  let fixture: ComponentFixture<ProfessorDaTurmaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorDaTurmaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorDaTurmaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
