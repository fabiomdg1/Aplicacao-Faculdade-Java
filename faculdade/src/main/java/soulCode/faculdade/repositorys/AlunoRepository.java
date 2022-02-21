package soulCode.faculdade.repositorys;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import soulCode.faculdade.models.Aluno;

//-------------------------Extendendo a classe JpaRepository---------------------------//
//------- JpaRepository disponibiliza 11 métodos para trabalhar com o CRUD ------------//
public interface AlunoRepository extends JpaRepository<Aluno,Integer>{
	
	//-------------- A notação @Query informa que vamos usar uma consulta SQL --------------//
	//-------------- A notação @nativeQuery informa que é uma query nativa do SQL ----------//
	@Query(value = "select * from aluno where id_turma = :id_turma", nativeQuery = true)
	List <Aluno> fetchByTurma(Integer id_turma);
	
	@Query(value="select ra_aluno, al_nome, al_cidade, tu_nome, tu_descricao from turma right join aluno on aluno.id_turma = turma.id_turma order by al_nome", nativeQuery = true)
	List<List> alunosComTurma();
}
