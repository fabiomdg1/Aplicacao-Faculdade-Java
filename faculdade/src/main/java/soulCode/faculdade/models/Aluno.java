package soulCode.faculdade.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


//---------------------- A anotação @Entity é utilizada para informar que uma classe também é uma entidade. ------------//
//---------------------- Uma entidade representa, na Orientação a Objetos, uma tabela do banco de dados-----------------//
//----------------------------Neste caso será criado no banco de dados uma tabela chamada Aluno ------------------------//
@Entity
public class Aluno {
	
	//----------------------------------------------------ID da Aluno---------------------------------------------------------------------//
	//------- A notação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária -----//
	//------- A notação @GeneratedValue responsabiliza o provedor de persistencia para que o ra_aluno seja único -------------------------//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ra_aluno;

	//---------------------------------------------Coluna al_nome-------------------------------------------------------------//
	//----- A anotação @Column é usada para realizar o mapeamento do campo da entidade com uma coluna do banco de dados. -----//
	@Column(nullable = false, length = 60)// Campo não pode ser nulo, tamanho máximo de 60 caracteres
	private String al_nome;
	
	//---------------------------------------------Coluna al_responsável------------------------------------------------------//
	//----- A anotação @Column é usada para realizar o mapeamento do campo da entidade com uma coluna do banco de dados. -----//
	@Column(nullable = true, length = 60)// Campo não pode ser nulo, tamanho máximo de 60 caracteres
	private String al_responsavel;
	
	//---------------------------------------------Coluna al_cidade-------------------------------------------------------------//
		//----- A anotação @Column é usada para realizar o mapeamento do campo da entidade com uma coluna do banco de dados. -----//
	@Column(nullable = false, length = 30)// Campo não pode ser nulo, tamanho máximo de 30 caracteres
	private String al_cidade;

	//----- Verificar JsonIgnore e ManyToOne-----//
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	//nullabel = true ==> pode ser nulo
	@Column (nullable=true, length = 60)
	private String al_idade;

	//----- Getters and Setters -----//

	public String getAl_idade() {
		return al_idade;
	}

	public void setAl_idade(String al_idade) {
		this.al_idade = al_idade;
	}

	public Integer getRa_aluno() {
		return ra_aluno;
	}
	
	public void setRa_aluno(Integer ra_aluno) {
		this.ra_aluno = ra_aluno;
	}
	

	public String getAl_nome() {
		return al_nome;
	}

	public void setAl_nome(String al_nome) {
		this.al_nome = al_nome;
	}

	public String getAl_responsavel() {
		return al_responsavel;
	}

	public void setAl_responsavel(String al_responsavel) {
		this.al_responsavel = al_responsavel;
	}

	public String getAl_cidade() {
		return al_cidade;
	}

	public void setAl_cidade(String al_cidade) {
		this.al_cidade = al_cidade;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	
}
