package soulCode.faculdade.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import soulCode.faculdade.models.Professor;
import soulCode.faculdade.services.ProfessorService;
import soulCode.faculdade.services.TurmaService;

@CrossOrigin
@RestController
@RequestMapping("faculdade")
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private TurmaService turmaService;

	
	@GetMapping("/professor")
	public List<Professor> mostrarTodosProfessores(){
		//List<Professor> professor = professorService.mostrarTodosProfessores();
		//return professor;
		return professorService.mostrarTodosProfessores();
	}
	
	@GetMapping("/professor/{id_professor}")
	public ResponseEntity<Professor> mostrarUmProfessor(@PathVariable Integer id_professor) {
		Professor professor = professorService.mostrarUmProfessor(id_professor);
		return ResponseEntity.ok().body(professor);
	}
	
	@GetMapping("/professor-turma/{id_turma}")
	public ResponseEntity<Professor>buscarProfessorDaTurma(@PathVariable Integer id_turma){
		Professor professor = professorService.buscarProfessorDaTurma(id_turma);
		return ResponseEntity.ok().body(professor);
	}
	
	@PostMapping("/professorSemTurma")
	public ResponseEntity<Professor> InserirProfessorSemTurma(@RequestBody Professor professor){
		professor = professorService.InserirProfessorSemTurma(professor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(professor.getId_professor()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	
	@PostMapping("/professor")
	public ResponseEntity<Professor> inserirProfessor(@RequestParam(value="turma", required=false)
	Integer id_turma, @RequestBody Professor professor){
		professor = professorService.InserirProfessorComTurma(id_turma, professor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(professor.getId_professor()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@PostMapping("/professorComTurma")
	public ResponseEntity<Professor> InserirProfessorComTurma(@RequestParam(value="turma")Integer id_turma, @RequestBody Professor professor){
		professor = professorService.InserirProfessorComTurma(id_turma, professor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(professor.getId_professor()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	
	@PutMapping("/professor/{id_professor}")
	public ResponseEntity<Professor> editarProfessor(@RequestParam(value="turma", required=false)Integer id_turma, @PathVariable Integer id_professor, @RequestBody Professor professor){
		professor.setId_professor(id_professor);
		
		
		professor = professorService.editarProfessor(id_turma, professor);
		return ResponseEntity.noContent().build();		
	}
	
	@GetMapping("/professorSemTurma")
	public List<Professor> professorSemTurma(){
		List<Professor> professor = professorService.professorSemTurma() ;
		return professor;
	}
	
}















