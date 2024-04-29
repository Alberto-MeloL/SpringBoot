package webapp.gerenciamento_escolar_ta.Repository.Professor;
import webapp.gerenciamento_escolar_ta.Model.Professor.VerificaCadProfessor;
import org.springframework.data.repository.CrudRepository;

public interface VerificaCadProfessorRepository extends CrudRepository<VerificaCadProfessor, String>{
    VerificaCadProfessor findByEmail(String email);
}
