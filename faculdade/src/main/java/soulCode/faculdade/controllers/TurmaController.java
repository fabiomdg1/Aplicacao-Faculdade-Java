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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import soulCode.faculdade.models.Turma;
import soulCode.faculdade.services.TurmaService;

//-------------------------------------A notação CrossOrigin evita o problema de Cors--------------------------//
@CrossOrigin


//------------------- A notação @RestController simplesmente retorna o objeto como JSON ou XML ----------------//
//------------------- E os dados do objeto são gravados diretamente na resposta HTTP --------------------------//
@RestController


//--------- A notação @RequestMapping Serve para disponibilizar os endereços da sua aplicação ao usuário final ------------//
//-------- Quando esses endereços forem acessados por algum cliente, ele terá acesso aos métodos desta classe. ------------//
//----- Neste caso, quando acessado irá disponibilizar os métodos Mostrar, Inserir, Deletar e Atualizar Turmas ------------//
@RequestMapping("faculdade")
public class TurmaController {
	
	//----- Utilizando a injeção de dependência da classe TurmaService -----//
	@Autowired
	private TurmaService turmaService;
	
	
	//--------------------------------------------------- GET --------------------------------------------------------------------//
	//----- Disponibilizando o método mostrarTodosAlunos através do endereço faculdade/turma por meio da notação @GetMapping -----//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o GET -----//
	@GetMapping("/turma")
	public List<Turma> mostrarTodasTurmas(){
		List<Turma> turma = turmaService.mostrarTodasTurmas();
		return turma;
	}
	
	
	//--------------------------------------------------- GET -----------------------------------------------------------------------------//
	//----- Disponibilizando o método mostrarTodosAlunos através do endereço faculdade/turma/id_turma por meio da notação @GetMapping -----//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o GET --------------//
	//----- A notação @PathVariable é utilizado quando o valor da variável é passada diretamente na URL -----------------------------------//	
	@GetMapping("/turma/{id_turma}")
	public ResponseEntity<Turma> buscarUmaTurma(@PathVariable Integer id_turma){
		Turma turma = turmaService.buscarUmaTurma(id_turma);
		return ResponseEntity.ok().body(turma);
	}
	
	
	//--------------------------------------------------- POST --------------------------------------------------------------------------------//
	//----- Disponibilizando o método create através do endereço faculdade/turma/ por meio da notação @GetMapping -------------------------//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o POST -------------//
	//----- A notação @RequestBody é utilizado quando o valor da variável é passada diretamente na URL -----------------------------------//
	@PostMapping("/turma")
	public ResponseEntity<Turma> create(@RequestBody Turma turma){
		turma = turmaService.create(turma);
		
		//--------------------------------------------------- URI --------------------------------------------------------------------//
		//-------------------- Basicamente o URI é composto pelo complemento da URL padrão do site -----------------------------------//
		//------------------------------ Passando parâmetros específicos para a aplicação --------------------------------------------//
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(turma.getId_turma()).toUri();
		return ResponseEntity.created(uri).build();				
	}
	
	//--------------------------------------------------- PUT ----------------------------------------------------------------------------//
	//----- Disponibilizando o método editar através do endereço faculdade/turma/id_turma por meio da notação @GetMapping ----------------//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o PUT -------------//
	//----- A notação @RequestBody é utilizado quando o valor da variável é passada diretamente na URL -----------------------------------//
	@PutMapping("/turma/{id_turma}")
	public ResponseEntity<Void> editarTurma(@PathVariable Integer id_turma, @RequestBody Turma turma){
		turma.setId_turma(id_turma);
		turma = turmaService.editarTurma(turma);
		return ResponseEntity.noContent().build();
	}
	
	//--------------------------------------------------- DELETE -------------------------------------------------------------------------//
	//----- Disponibilizando o método editar através do endereço faculdade/turma/id_turma por meio da notação @GetMapping ----------------//
	//----- A diferença para o RequestMapping é que o @GetMapping especifica os tipos de solicitações HTTP. Neste caso o PUT -------------//

	@DeleteMapping("/turma/{id_turma}")
	public ResponseEntity<Void> deletarUmaTurma(@PathVariable Integer id_turma){
		turmaService.deletarUmaTurma(id_turma);
		return ResponseEntity.noContent().build();
	}
	
}






















