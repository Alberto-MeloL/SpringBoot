package webapp.gerenciamento_escolar_ta.Repository.Administrador;

import org.springframework.data.repository.CrudRepository;

import webapp.gerenciamento_escolar_ta.Model.Administrador.AdministradorModel;

public interface AdministradorRepository extends CrudRepository<AdministradorModel, String>{
    
    AdministradorModel findByCpf(String cpf);
    AdministradorModel findBySenha(String senha);
}
