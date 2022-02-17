package soulCode.faculdade.services.exceptions;

//----------Tratamento de Erro - Criando msg de Exception Personalizada------------------//
//----- Toda vez que criarmos uma classe para tratamento de excessão,
//----- precisamos extender a classe RuntimeException 
//----- A RuntimeException trata os erros em tempo de execução-----//
public class ObjectNotFoundException extends RuntimeException {

	//----- É criado a versão 1, e a medida que for feito alterações na aplicação, 
	//----- esta versão será mudada -----//
	private static final long serialVersionUID = 1L;

	
	//----- Construtor que mostra também a causa -----//
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	//----- Construtor -----//
	public ObjectNotFoundException(String message) {
		super(message);
	}	
	
}
