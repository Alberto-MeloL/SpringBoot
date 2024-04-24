package webapp.gerenciamento_escolar_ta.Model.Administrador;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//cria a tabela no banco de dados
@Entity
public class VerificaCadastroAdm implements Serializable {
    // atributos

    @Id
    private String cpf;
    private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
