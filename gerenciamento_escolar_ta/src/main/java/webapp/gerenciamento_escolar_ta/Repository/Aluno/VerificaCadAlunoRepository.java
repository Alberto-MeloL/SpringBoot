package webapp.gerenciamento_escolar_ta.Repository.Aluno;
import webapp.gerenciamento_escolar_ta.Model.Aluno.VerificaCadAluno;
import org.springframework.data.repository.CrudRepository;

public interface VerificaCadAlunoRepository extends CrudRepository<VerificaCadAluno, String> {
    VerificaCadAluno findByEmail(String email);
}
