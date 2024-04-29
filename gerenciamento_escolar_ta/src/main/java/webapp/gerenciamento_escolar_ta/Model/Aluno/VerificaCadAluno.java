package webapp.gerenciamento_escolar_ta.Model.Aluno;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class VerificaCadAluno implements Serializable {
    @Id
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
