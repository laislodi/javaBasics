package examples;

public class Cadastro {

    private final String cpf;
    private final String nome;
    private final int idade;

    public Cadastro(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cadastro cadastro = (Cadastro) o;

        if (idade != cadastro.idade) return false;
        if (cpf != null ? !cpf.equals(cadastro.cpf) : cadastro.cpf != null) return false;
        return nome != null ? nome.equals(cadastro.nome) : cadastro.nome == null;
    }

    @Override
    public int hashCode() {
        int result = cpf != null ? cpf.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + idade;
        return result;
    }

    @Override
    public String toString() {
        return "{" + cpf + ", " + nome + ", " + idade + '}';
    }
}
