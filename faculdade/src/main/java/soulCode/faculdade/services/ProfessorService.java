package soulCode.faculdade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soulCode.faculdade.models.Professor;
import soulCode.faculdade.repositorys.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> mostrarTodosProfessores(){
		return professorRepository.findAll();
	}
}
