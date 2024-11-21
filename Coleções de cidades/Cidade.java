import java.util.Objects;

public class Cidade implements Comparable<Cidade> {
    private String nome;
    private boolean isCapital;

    public Cidade(String nome, boolean isCapital) {
        this.nome = nome;
        this.isCapital = isCapital;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCapital() {
        return isCapital;
    }

    @Override
    public int compareTo(Cidade outra) {
        return this.nome.compareTo(outra.nome);
    }

    @Override
    public String toString() {
        return nome + (isCapital ? " (Capital)" : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cidade cidade = (Cidade) obj;
        return nome.equals(cidade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

