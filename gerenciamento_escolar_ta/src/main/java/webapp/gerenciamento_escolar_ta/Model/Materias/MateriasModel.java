package webapp.gerenciamento_escolar_ta.Model.Materias;

public class MateriasModel {
    private String nomeMateria;
    private double nota;

    public MateriasModel(String nomeMateria, double nota) {

        this.nomeMateria = nomeMateria;
        this.nota = nota;

    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
