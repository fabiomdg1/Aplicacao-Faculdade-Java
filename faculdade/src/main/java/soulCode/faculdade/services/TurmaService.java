package soulCode.faculdade.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import soulCode.faculdade.models.Professor;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.repositorys.TurmaRepository;
import soulCode.faculdade.services.exceptions.ObjectNotFoundException;

//----------------------------------------------- Service -------------------------------------------------------//
//---------- A notação @Service define uma classe como pertencente à camada de Serviço da aplicação. ------------//
@Service
public class TurmaService {
	
	
	//------- Utilizando a injeção de dependência de JpaRepository por meio da Interface TurmaRepository -------//
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Lazy
	@Autowired
	private ProfessorService professorService;
	
	//-------------------------------------- Mostrar todas as Turmas -------------------------------------------//
	public List<Turma> mostrarTodasTurmas(){
		return turmaRepository.findAll();
	}
	
	//-------------------------------------- Buscar uma Turma Específica --------------------------------------//
	// Optional - economiza código, implementa uma verificação se existe ou não o aluno no banco de dados -----//
	// Optional - se não encontrar o aluno não vai parar a aplicação ------------------------------------------//
	public Turma buscarUmaTurma(Integer id_turma) {
		Optional<Turma> turma = turmaRepository.findById(id_turma);

		//----- Tratamento de erro caso não for encontrado o registro da turma ------------------//
		//----- Precisamos tratar o erro no Nivel de Serviço e depois no Nível de Controller ----//
		//----- Retorna turma ou retorna exception que criamos no package service.exception -----//
		return turma.orElseThrow(() -> new soulCode.faculdade.services.exceptions.ObjectNotFoundException(
				"Objeto não cadastrado! O id procurado foi: " + id_turma));
	}
	
	
	public List<Turma> turmaSemProfessor(){
		return turmaRepository.turmaSemProfessor();
	}
	
	public Turma turmaDoProfessor(Integer id_professor) {
		Turma turma = turmaRepository.turmaDoProfessor(id_professor);
		return turma;
	}
	
	
	public List<List> turmaComSeuProfessor(){
		return turmaRepository.turmaComSeuProfessor();
	}
	public Turma cadastrarTurma(Integer id_professor, Turma turma) {
		// é uma forma de segurança para não setarmos o id
		turma.setId_turma(null);
		if (id_professor != null) {
			Professor professor = professorService.mostrarUmProfessor(id_professor);
			turma.setProfessor(professor);
			
		}
		
		return turmaRepository.save(turma);
	}

	public Turma editarTurma(Turma turma) {
		buscarUmaTurma(turma.getId_turma());
		return turmaRepository.save(turma);
	}

	public void deletarUmaTurma(Integer id_turma) {
		buscarUmaTurma(id_turma);
		try {
			turmaRepository.deleteById(id_turma);
		}catch(org.springframework.dao.DataIntegrityViolationException e) {
			throw new soulCode.faculdade.services.exceptions.DataIntegrityViolationException(
					"A turma não pode ser deletada! Possui alunos relacionados!");
		}
		
	}

	public Turma atribuirProfessor(Integer id_turma,Integer id_professor){
		Turma turma = buscarUmaTurma(id_turma);
		Professor professorAnterior = professorService.buscarProfessorDaTurma(id_turma);
		Professor professor = professorService.mostrarUmProfessor(id_professor);
		if(turma.getProfessor()!=null) {
			turma.setProfessor(null);
			professorAnterior.setTurma(null);
		}
		turma.setProfessor(professor);
		professor.setTurma(turma);
		return turmaRepository.save(turma);
	}
	
	public Turma deixarTurmaSemProfessor(Integer id_turma, Integer id_professor) {
		Turma turma = buscarUmaTurma(id_turma);
		turma.setProfessor(null);
		Professor professor = professorService.mostrarUmProfessor(id_professor);
		professor.setTurma(null);
		return turmaRepository.save(turma);
	}
}
