package soulCode.faculdade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soulCode.faculdade.models.Professor;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.repositorys.ProfessorRepository;
import soulCode.faculdade.repositorys.TurmaRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Professor> mostrarTodosProfessores(){
		return professorRepository.findAll();
	}
	
	public Professor mostrarUmProfessor(Integer id_professor) {
		Optional<Professor> professor = professorRepository.findById(id_professor);
		return professor.orElseThrow();		
	}
	
	public Professor InserirProfessorSemTurma(Professor professor) {
		professor.setId_professor(null);
		return professorRepository.save(professor);
	}
	
	public Professor InserirProfessorComTurma(Integer id_turma, Professor professor) {
		professor.setId_professor(null);
		Turma turma = turmaService.buscarUmaTurma(id_turma);
		professor.setTurma(turma);
		return professorRepository.save(professor);
	}
	
	public Professor editarProfessor(Integer id_turma, Professor professor) {
		
		if(id_turma != null) {
			Professor dadosProfAntesDaMudanca = mostrarUmProfessor(professor.getId_professor());
			Turma turmaAnterior = dadosProfAntesDaMudanca.getTurma();
			
			if(turmaAnterior != null) {
				turmaAnterior.setProfessor(null);
				turmaRepository.save(turmaAnterior);				
			}		
			
			Turma turma = turmaService.buscarUmaTurma(id_turma);
			professor.setTurma(turma);
			turma.setProfessor(professor);			
		}		
		return professorRepository.save(professor);
	}
	
	public Professor InserirProfessor(Integer id_turma, Professor professor) {
		professor.setId_professor(null);
		
		if(id_turma != null) {
			Turma turma = turmaService.buscarUmaTurma(id_turma);
			professor.setTurma(turma);		
			turma.setProfessor(professor);
		}
		return professorRepository.save(professor);		
	}
	
	public Professor buscarProfessorDaTurma(Integer id_turma) {
		Professor professor = professorRepository.buscaProfessorDaTurma(id_turma);
		return professor;
	}
}




















