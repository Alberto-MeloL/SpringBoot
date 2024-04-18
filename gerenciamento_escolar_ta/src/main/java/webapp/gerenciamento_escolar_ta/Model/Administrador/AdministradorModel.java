package webapp.gerenciamento_escolar_ta.Model.Administrador;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//cria a tabela no banco de dados
@Entity
public class AdministradorModel implements Serializable {

    // atributos

    @Id
    String cpf;
    String nome;
    String email;
    String senha;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
