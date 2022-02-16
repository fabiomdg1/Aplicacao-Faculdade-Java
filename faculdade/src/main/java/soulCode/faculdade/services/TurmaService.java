package soulCode.faculdade.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.repositorys.TurmaRepository;

//----------------------------------------------- Service -------------------------------------------------------//
//---------- A notação @Service define uma classe como pertencente à camada de Serviço da aplicação. ------------//
@Service
public class TurmaService {
	
	
	//------- Utilizando a injeção de dependência de JpaRepository por meio da Interface TurmaRepository -------//
	@Autowired
	private TurmaRepository turmaRepository;
	
	//-------------------------------------- Mostrar todas as Turmas -------------------------------------------//
	public List<Turma> mostrarTodasTurmas(){
		return turmaRepository.findAll();
	}
	
	//-------------------------------------- Mostrar uma Turma Específica --------------------------------------//
	// Optional - economiza código, implementa uma verificação se existe ou não o aluno no banco de dados ------//
	// Optional - se não encontrar o aluno não vai parar a aplicação -------------------------------------------//
	public Turma buscarUmaTurma(Integer id_turma) {
		Optional<Turma> turma = turmaRepository.findById(id_turma);
		return turma.orElseThrow();
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
	public void deletarUmaTurma(Integer id_turma) {
		//Aqui serão implementadas as classes de exceptions
	}
}
