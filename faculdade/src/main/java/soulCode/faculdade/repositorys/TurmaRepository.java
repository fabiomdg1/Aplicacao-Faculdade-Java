package soulCode.faculdade.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import soulCode.faculdade.models.Turma;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface TurmaRepository extends JpaRepository<Turma,Integer>{

	@Query(value="SELECT * FROM turma WHERE id_professor is null", nativeQuery = true)
	List<Turma> turmaSemProfessor();
	
	@Query(value="SELECT * FROM turma where id_professor =:id_professor",nativeQuery = true)
	Turma turmaDoProfessor(Integer id_professor);
	
	@Query(value="SELECT turma.id_turma,turma.tu_nome,turma.tu_descricao,professor.id_professor,professor.pro_nome,professor.pro_formacao FROM turma left JOIN professor ON professor.id_turma = turma.id_turma order by turma.tu_nome;",nativeQuery = true)
	List<List> turmaComSeuProfessor();
}