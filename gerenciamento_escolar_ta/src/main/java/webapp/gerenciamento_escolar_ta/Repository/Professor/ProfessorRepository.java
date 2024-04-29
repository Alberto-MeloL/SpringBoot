package webapp.gerenciamento_escolar_ta.Repository.Professor;
import org.springframework.data.repository.CrudRepository;
import webapp.gerenciamento_escolar_ta.Model.Professor.ProfessorModel;

public interface ProfessorRepository extends CrudRepository<ProfessorModel, String>{
    ProfessorModel findByEmail(String email);
    ProfessorModel findBySenha(String senha);
}
