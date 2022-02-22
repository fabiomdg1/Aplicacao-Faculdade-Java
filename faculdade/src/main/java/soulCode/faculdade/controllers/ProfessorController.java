package soulCode.faculdade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soulCode.faculdade.models.Professor;
import soulCode.faculdade.services.ProfessorService;

@CrossOrigin
@RestController
@RequestMapping("faculdade")
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/professor")
	public List<Professor> mostrarTodosProfessores(){
		//List<Professor> professor = professorService.mostrarTodosProfessores();
		//return professor;
		return professorService.mostrarTodosProfessores();
	}
}
