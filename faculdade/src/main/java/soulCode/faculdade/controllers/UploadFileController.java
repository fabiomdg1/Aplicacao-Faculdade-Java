package soulCode.faculdade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import soulCode.faculdade.services.ProfessorService;
import soulCode.faculdade.utils.UploadFileUtil;

@RestController
@RequestMapping("faculdade")
@CrossOrigin
public class UploadFileController {
	
	@Autowired
	ProfessorService professorService;
	
	@PostMapping("/envio/{id_professor}")
	public ResponseEntity<String> enviarDados(@PathVariable Integer Id_professor, MultipartFile foto, @RequestParam("@RequestParam") String nome){
		
		String fileName = nome;
		
		String uploadDir = "/SpringToolsWorkspace/imagens";
		String nomeMaisCaminho = "G:" + uploadDir + "/" + nome;
		
		professorService.salvarFoto(Id_professor, nomeMaisCaminho);
		
		try {
			UploadFileUtil.salvarArquivo(uploadDir, fileName, foto);			
		}catch(Exception e) {
			System.out.println("O arquivo não foi enviado " + e);
		}
		
		System.out.println("Arquivo enviado com sucesso: " + nomeMaisCaminho);
		return ResponseEntity.ok("Arquivo Enviado !");	}
}
