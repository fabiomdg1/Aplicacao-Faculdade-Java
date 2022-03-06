//package soulCode.faculdade.controllers;
//
//import java.net.URI;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import soulCode.faculdade.models.Boleto;
//import soulCode.faculdade.services.BoletoService;
//
//
//@CrossOrigin @RestController @RequestMapping("faculdade")
//public class BoletoController {
//	
//		@Autowired
//		private BoletoService boletoService;
//		
//		@GetMapping("/aluno/boleto")
//		public List<Boleto> BuscarTodosBoletos(){
//			List<Boleto> boleto = boletoService.buscarTodosBoletos();
//			return boleto;
//		}
//		
//		@GetMapping("/aluno/boleto/{codigo}")
//		public ResponseEntity<Boleto> buscarUmBoleto(@PathVariable Integer codigo){
//			Boleto boleto  = boletoService.buscarUmBoleto(codigo);
//			return ResponseEntity.ok().body(boleto);
//			
//		}
//		
//		@GetMapping("/aluno/boletosDoAluno/{ra_aluno}")
//		public List<Boleto> buscarBoletosDoAluno(@PathVariable Integer ra_aluno){
//			List<Boleto> boleto = boletoService.buscarBoletosDoAluno(ra_aluno);
//			return boleto;
//		}
//		
//		@PostMapping("/aluno/boleto/{ra_aluno}")
//		public ResponseEntity<Boleto> InserirBoleto(@RequestBody Boleto boleto, @PathVariable Integer ra_aluno){
//			boleto = boletoService.InserirBoleto(boleto,ra_aluno);
//			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//					.buildAndExpand(boleto.getCodigo()).toUri();
//			return ResponseEntity.created(uri).build();
//			
//		}
//		
//		@DeleteMapping("/aluno/boleto/{codigo}")
//		public ResponseEntity<Void> deletarUmBoleto(@PathVariable Integer codigo){
//			boletoService.deletarUmBoleto(codigo);
//			return ResponseEntity.noContent().build();
//		}
//		
//		@PutMapping("/aluno/boleto/{codigo}")
//		public ResponseEntity<Boleto> editarBoleto(@PathVariable Integer codigo, @RequestBody Boleto boleto){
//			boleto.setCodigo(codigo);
//			boleto = boletoService.editarBoleto(boleto);
//			return ResponseEntity.noContent().build();
//		}
//
//}
