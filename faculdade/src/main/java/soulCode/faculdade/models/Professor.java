package soulCode.faculdade.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_professor;
	
	@Column(nullable = false, length=40)
	private String pro_nome;
	
	@Column(nullable = true, length=40)
	private String pro_formacao;
	
	//Ignora os dados da turma para não ocorrer loop
	
	@OneToOne
	@JoinColumn(name = "id_turma", unique = true)	
	
	private Turma turma;

	
	//----- Getters and Setters -----//
	public Integer getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

	public String getPro_nome() {
		return pro_nome;
	}

	public void setPro_nome(String pro_nome) {
		this.pro_nome = pro_nome;
	}

	public String getPro_formacao() {
		return pro_formacao;
	}

	public void setPro_formacao(String pro_formacao) {
		this.pro_formacao = pro_formacao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
