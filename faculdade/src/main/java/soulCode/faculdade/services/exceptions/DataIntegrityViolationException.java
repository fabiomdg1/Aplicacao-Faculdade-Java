package soulCode.faculdade.services.exceptions;

//----- O nome da classe é o mesmo nome do erro que estamos tratando ---------------------------//
//----- Estamos tratando o erro DataIntegrityViolationException --------------------------------//
//----- Este erro ocorre quando tentamos deletar uma turma que tem alunos vinculados a ela -----//
public class DataIntegrityViolationException extends RuntimeException {

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
	
}
