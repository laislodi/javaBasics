package school;

import school.datautil.DataUtil;

import java.util.Calendar;
import java.util.Objects;

public class Aluno {
    private String matricula;
    private String nome;
    private Calendar dataDeNascimento;
    private Double nota;
    private Double frequencia;

    public Aluno(String matricula, String nome, Calendar dataDeNascimento, Double nota, Double frequencia) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.nota = nota;
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getNome(), aluno.getNome()) &&
                Objects.equals(getDataDeNascimento(), aluno.getDataDeNascimento()) &&
                Objects.equals(getNota(), aluno.getNota()) &&
                Objects.equals(getFrequencia(), aluno.getFrequencia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDataDeNascimento(), getNota(), getFrequencia());
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + "\n"
             + "Nome: " + nome + "\n"
             + "Data De Nascimento: " + DataUtil.calendarToString(dataDeNascimento) + "\n"
             + "Nota: " + String.format("%.1f",nota) + "\n"
             + "Frequencia: " + String.format("%.0f", frequencia) + "%\n";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Calendar dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }
}
