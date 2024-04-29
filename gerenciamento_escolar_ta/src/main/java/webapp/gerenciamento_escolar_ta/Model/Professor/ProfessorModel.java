package webapp.gerenciamento_escolar_ta.Model.Professor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProfessorModel {
    @Id
    String email;
    String nome;
    String idade;
    String senha;

    public String getNomeProfessor() {
        return nome;
    }

    public void setNomeProfessor(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade; 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
