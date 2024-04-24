package webapp.gerenciamento_escolar_ta.Repository.Administrador;

import org.springframework.data.repository.CrudRepository;

import webapp.gerenciamento_escolar_ta.Model.Administrador.VerificaCadastroAdm;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String>{
   
    VerificaCadastroAdm findByCpf(String cpf);
}
    