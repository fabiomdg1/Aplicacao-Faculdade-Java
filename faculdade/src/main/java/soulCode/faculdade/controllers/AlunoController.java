package soulCode.faculdade.controllers;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import soulCode.faculdade.models.Aluno;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.repositorys.AlunoRepository;
import soulCode.faculdade.services.AlunoService;

//-------------------------------------A notação CrossOrigin evita o problema de Cors--------------------------//
@CrossOrigin


//------------------- A notação @RestController simplesmente retorna o objeto como JSON ou XML ----------------//
//------------------- E os dados do objeto são gravados diretamente na resposta HTTP --------------------------//
@RestController


//--------- A notação @RequestMapping Serve para disponibilizar os endereços da sua aplicação ao usuário final ------------//
//-------- Quando esses endereços forem acessados por algum cliente, ele terá acesso aos métodos desta classe. ------------//
//----- Neste caso, quando acessado irá disponibilizar os métodos Mostrar, Inserir, Deletar e Atualizar Funcionários ------//
@RequestMapping("faculdade")
public class AlunoController {

	
	//----- Utilizando a injeção de dependência de JpaRepository -----//
	//@Autowired
	//private AlunoRepository alunoRepository;

	
	//----- Utilizando a injeção de dependência da classe Aluno -----//
	@Autowired
	private AlunoService alunoService;

	
	//--------------------------------------------------- GET ---------------------------------------------------------------------//
	//----- Disponibilizando o método mostrarTodosAlunos através do endereço faculdade/alunos por meio da notação @GetMapping -----//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o GET ------//
	@GetMapping("/aluno")
	private List<Aluno> mostrarTodosAlunos() {
		List<Aluno> aluno = alunoService.mostrarTodosAlunos();
		return aluno;
	}
	
	//--------------------------------------------------- GET ---------------------------------------------------------------------//
	//----- Disponibilizando o método buscarUmAluno através do endereço faculdade/ra_aluno por meio da notação @GetMapping --------//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o GET ------//
	@GetMapping("/aluno/{ra_aluno}")
	public ResponseEntity<Aluno> buscarUmAluno(@PathVariable Integer ra_aluno) {
		Aluno aluno = alunoService.buscarUmAluno(ra_aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	//----------------------------------------------------- GET --------------------------------------------------------------------------------//
		//----- Disponibilizando o método buscarAlunoTurma através do endereço faculdade/aluno/busca-turma, aluno por meio da notação @GetMapping -----//
		//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o GET -------------------//
		@GetMapping("/aluno/busca-turma/{id_turma}")
		public List<Aluno> buscarAlunoTurma(@PathVariable Integer id_turma){
			List<Aluno> aluno = alunoService.buscarAlunoTurma(id_turma);
			return aluno;
		}
	
	//--------------------------------------------------- POST --------------------------------------------------------------------//
	//----- Disponibilizando o método inserirAluno através do endereço faculdade/aluno por meio da notação @PostMapping -----------//
	//----- A diferença para o RequestMapping é que o @PostMapping especifica os tipos de solicitações HTTP. Neste caso o POST ----//
	@PostMapping("/aluno")
	public ResponseEntity<Aluno> InserirAluno(@RequestParam(value="turma")Integer id_turma,	@RequestBody Aluno aluno){	
		aluno = alunoService.InserirAluno(id_turma, aluno);
		
		

	//--------------------------------------------------- URI --------------------------------------------------------------------//
	//-------------------- Basicamente o URI é composto pelo complemento da URL padrão do site -----------------------------------//
	//------------------------------ Passando parâmetros específicos para a aplicação --------------------------------------------//
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/aluno/{id}").buildAndExpand(aluno.getRa_aluno()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	
	//--------------------------------------------------- DELETE --------------------------------------------------------------------------//
	//----- Disponibilizando o método deletarUmAluno através do endereço faculdade/aluno/ra_aluno por meio da notação @DeletetMapping -----//
	//----- A diferença para o RequestMapping é que o @DeleteMapping especifica os tipos de solicitações HTTP. Neste caso o DELETE --------//
	@DeleteMapping("/aluno/{ra_aluno}")
	public ResponseEntity<Void> deletarUmAluno(@PathVariable Integer ra_aluno){
		alunoService.deletarUmAluno(ra_aluno);
		return ResponseEntity.noContent().build();
	}
	
	
	//----------------------------------------------------- PUT ---------------------------------------------------------------------------//
	//----- Disponibilizando o método editarAluno através do endereço faculdade/aluno/ra_aluno, aluno por meio da notação @PutMapping -----//
	//----- A diferença para o RequestMapping é que o @PutMapping especifica os tipos de solicitações HTTP. Neste caso o PUT --------------//
	@PutMapping("aluno/{ra_aluno}")	//
	public ResponseEntity<Void> editarAluno(@RequestParam(value="turma")Turma turma, @PathVariable Integer ra_aluno, @RequestBody Aluno aluno){		
		aluno.setRa_aluno(ra_aluno);
		aluno.setTurma(turma);
		aluno = alunoService.editarAluno(aluno);
		return ResponseEntity.noContent().build();
	}
	
	
	
	//@PutMapping("/aluno/{ra_aluno}")
	//public ResponseEntity<Void> editarAluno(@PathVariable Integer ra_aluno, @RequestBody Aluno aluno){
	//	aluno.setRa_aluno(ra_aluno);
	//	aluno = alunoService.editarAluno(aluno);
	//	return ResponseEntity.noContent().build();
	//}
	
	
	
	
	
	
}
