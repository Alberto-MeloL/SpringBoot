package webapp.gerenciamento_escolar_ta.Model.Materias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MateriasModel {
 @Id
 private Long id;
 private String nome;

 public MateriasModel(){}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

 
}
