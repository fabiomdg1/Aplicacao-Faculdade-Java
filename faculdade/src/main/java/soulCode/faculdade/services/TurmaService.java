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
		return turma.orElseThrow(()-> new ObjectNotFoundException("Objeto não cadastrado"));
	}
	
	//-------------------------------------------- Criar uma Turma ----------------------------------------------//
	public Turma create(Turma turma) {
		turma.setId_turma(null);
		return turmaRepository.save(turma);
	}
	
	//-------------------------------------------- Editar uma Turma ----------------------------------------------//
	public Turma editarTurma(Turma turma) {
		buscarUmaTurma(turma.getId_turma());
		return turmaRepository.save(turma);
	}
	
	//-------------------------------------------- Deletar uma Turma ---------------------------------------------//
	//------------ Se houver algum aluno vinculado a esta turma, não é possível deletar --------------------------//
	public void deletarUmaTurma(Integer id_turma) {
		
		buscarUmaTurma(id_turma);
		
		try {
			turmaRepository.deleteById(id_turma);
		//----- Pega o tipo de erro DataIntegrityViolationException e instanciamos no e -----//
		}catch(org.springframework.dao.DataIntegrityViolationException e) {

			//----- No lançamento da exceção,usamos a que criamos -----//
			throw new soulCode.faculdade.services.exceptions
			.DataIntegrityViolationException("A turma não pode ser deletada, porque possui alunos relacionados");
		}
		
		
	}
	
	  public Turma atribuirProfessor(Integer id_turma, Integer id_professor){
		  Turma turma = buscarUmaTurma(id_turma);
		  Professor professor = professorService.mostrarUmProfessor(id_professor);
		  turma.setProfessor(professor);
		  professor.setTurma(turma);
		  return turmaRepository.save(turma);
	  }
}
