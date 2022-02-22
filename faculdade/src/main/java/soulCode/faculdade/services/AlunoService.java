package soulCode.faculdade.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soulCode.faculdade.models.Aluno;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.repositorys.AlunoRepository;

//----------------------------------------------- Service -------------------------------------------------------//
//---------- A notação @Service define uma classe como pertencente à camada de Serviço da aplicação. ------------//
@Service
public class AlunoService {
	
	//------- Utilizando a injeção de dependência de JpaRepository por meio da Interface TurmaRepository -------//
	@Autowired
	private AlunoRepository alunoRepository; 
	
	//------- Utilizando a injeção de dependência da classe TurmaService ---------------------------------------//
	@Autowired
	private TurmaService turmaService;
	
	//-------------------------------------- Mostrar todas os Alunos -------------------------------------------//
	public List <Aluno> mostrarTodosAlunos(){
		return alunoRepository.findAll();
	}
	
	//-------------------------------------- Buscar um Aluno ---------------------------------------------------//
	// Optional - economiza código, implementa uma verificação se existe ou não o aluno no banco de dados ------//
	// Optional - se não encontrar o aluno não vai parar a aplicação -------------------------------------------//
	public Aluno buscarUmAluno(Integer ra_aluno) {
		// O ra_aluno foi definido como primary key na classe Aluno
		Optional<Aluno> aluno = alunoRepository.findById(ra_aluno);
		return aluno.orElseThrow();
	}
	
	//-------------------------------------- Buscar Todos Alunos Com Turma --------------------------------------//
	public List<List> alunosComTurma(){
		return alunoRepository.alunosComTurma();		
	}
	
	//-------------------------------------- Inserir Aluno ------------------------------------------------------//
	public Aluno InserirAluno(Integer id_turma, Aluno aluno) {
		aluno.setRa_aluno(null);
		Turma turma = turmaService.buscarUmaTurma(id_turma);
		aluno.setTurma(turma);
		return alunoRepository.save(aluno);
	}
	
	//-------------------------------------- Deletar Aluno ------------------------------------------------------//
	public void deletarUmAluno(Integer ra_aluno) {
		alunoRepository.deleteById(ra_aluno);		
	}
	
	//-------------------------------------- Editar Aluno ------------------------------------------------------//
	public Aluno editarAluno(Aluno aluno) {
		buscarUmAluno(aluno.getRa_aluno());
		return alunoRepository.save(aluno);
	}
	
	//---------------------- Buscar todos alunos de uma turma específica ---------------------------------------//
	public List<Aluno> buscarAlunoTurma(Integer id_turma){
		List<Aluno> aluno = alunoRepository.fetchByTurma(id_turma);
		return aluno;
	}
	
}










