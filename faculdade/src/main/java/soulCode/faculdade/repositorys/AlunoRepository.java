package soulCode.faculdade.repositorys;
import org.springframework.data.jpa.repository.JpaRepository;
import soulCode.faculdade.models.Aluno;

//JpaRepository disponibiliza 11 métodos para trabalhar com o CRUD
public interface AlunoRepository extends JpaRepository<Aluno,Integer>{
	
}
