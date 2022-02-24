package soulCode.faculdade.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import soulCode.faculdade.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
	@Query(value="select * from professor where id_turma = :id_turma", nativeQuery = true)
	Professor buscaProfessorDaTurma(Integer id_turma); 
		
}