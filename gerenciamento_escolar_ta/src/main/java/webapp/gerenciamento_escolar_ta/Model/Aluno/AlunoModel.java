package webapp.gerenciamento_escolar_ta.Model.Aluno;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import webapp.gerenciamento_escolar_ta.Model.Materias.MateriasModel;

@Entity
public class AlunoModel implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
   private String senha;

   public String getSenha() {
    return senha;
}

public void setSenha(String senha) {
    this.senha = senha;
}

@ManyToMany(fetch = FetchType.LAZY)

   @JoinTable(name = "aluno_materia",
   joinColumns = @JoinColumn(name = "aluno_id"),
   inverseJoinColumns = @JoinColumn(name = "materia_id"))
   private Set<MateriasModel> materias = new HashSet<>();
   
   public AlunoModel(){}

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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public Set<MateriasModel> getMaterias() {
    return materias;
}

public void setMaterias(Set<MateriasModel> materias) {
    this.materias = materias;
}

   
}

