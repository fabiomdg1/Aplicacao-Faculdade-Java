package soulCode.faculdade.controllers.exceptions;

//----------Tratamento de Erro ------------------//
//----- Através desta classe conseguimos obter qual foi o horário que ocorreu o erro -----//
//----- Através desta classe conseguimos obter o status do erro, exemplo erro 500 --------//
//----- Através desta classe conseguimos escrever uma msg personalizada do erro ----------//
public class StandardError {

	//----- Declarando Variáveis -----//
	private Long timestamp;
	private Integer status;
	private String error;
	
	//----- Construtor -----//
	public StandardError(Long timestamp, Integer status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}
	
	//----- Getters and Settings -----//
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
