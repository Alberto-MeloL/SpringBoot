package webapp.gerenciamento_escolar_ta.Repository.Aluno;

import org.springframework.data.repository.CrudRepository;

import webapp.gerenciamento_escolar_ta.Model.Aluno.AlunoModel;

public interface AlunoRepository extends CrudRepository<AlunoModel, Long>{
    AlunoModel findByNome(String nome);
    AlunoModel findByEmail(String email);
    AlunoModel findBySenha(String senha);
}
