package soulCode.faculdade.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//---------------------- A anotação @Entity é utilizada para informar que uma classe também é uma entidade. ------------//
//---------------------- Uma entidade representa, na Orientação a Objetos, uma tabela do banco de dados-----------------//
//----------------------------Neste caso será criado no banco de dados uma tabela chamada Turma ------------------------//
@Entity
public class Turma {
	
	
	//----------------------------------------------------ID da Turma---------------------------------------------------------------------//
	//------- A notação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária -----//
	//------- A notação @GeneratedValue responsabiliza o provedor de persistencia para que o id_turma seja único -------------------------// 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_turma;
	
	//---------------------------------------------Coluna tu_nome-------------------------------------------------------------//
	//----- A anotação @Column é usada para realizar o mapeamento do campo da entidade com uma coluna do banco de dados. -----// 
	@Column(nullable = false, length=60)
	private String tu_nome;
	
	//---------------------------------------------Coluna tu_descrição--------------------------------------------------------//
	//----- A anotação @Column é usada para realizar o mapeamento do campo da entidade com uma coluna do banco de dados. -----//
	@Column(nullable = false, length=60)
	private String tu_descricao;
	
	//----------------------------------- Uma turma pode ter um Array de Alunos -------------------------------------------//
	//---------------------------------------- Relacionamento OneToMany----------------------------------------------------//
	//----- A notação @OneToMany significa que uma entidade está relacionado com vários registros de outras entidades -----//
	@OneToMany(mappedBy = "turma")
	private List<Aluno> aluno = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "id_professor", unique = true)
	private Turma turma;
	
	
	 //----- Getters and Setters -----//
	
	public Integer getId_turma() {
		return id_turma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}

	public String getTu_nome() {
		return tu_nome;
	}

	public void setTu_nome(String tu_nome) {
		this.tu_nome = tu_nome;
	}

	public String getTu_descricao() {
		return tu_descricao;
	}

	public void setTu_descricao(String tu_descricao) {
		this.tu_descricao = tu_descricao;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}	
	
	
	
}
