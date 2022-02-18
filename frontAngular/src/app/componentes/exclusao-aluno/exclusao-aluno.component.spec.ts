import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExclusaoAlunoComponent } from './exclusao-aluno.component';

describe('ExclusaoAlunoComponent', () => {
  let component: ExclusaoAlunoComponent;
  let fixture: ComponentFixture<ExclusaoAlunoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExclusaoAlunoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExclusaoAlunoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
