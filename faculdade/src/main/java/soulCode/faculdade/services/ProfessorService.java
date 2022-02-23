package soulCode.faculdade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soulCode.faculdade.models.Professor;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.repositorys.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private TurmaService turmaService;
	
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
	
	public Professor editarProfessor(Professor professor) {
		mostrarUmProfessor(professor.getId_professor());
		return professorRepository.save(professor);
	}
}




















