package webapp.cadastro;

import org.springframework.data.repository.CrudRepository;

public interface AdmRepository extends CrudRepository<Administrador, Long>{
    
    //busca por chave primária
    Administrador findById(long id);

    //busca por nome
    Administrador findByNome(String nome);


}
