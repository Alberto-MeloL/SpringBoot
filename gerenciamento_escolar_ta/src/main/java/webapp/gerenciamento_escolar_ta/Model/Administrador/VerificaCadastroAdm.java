package webapp.gerenciamento_escolar_ta.Model.Administrador;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//cria a tabela no banco de dados
@Entity
public class VerificaCadastroAdm implements Serializable {
    // atributos

    @Id
    String cpf;
    String email;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
