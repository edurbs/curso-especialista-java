import java.util.Objects;

public class Estado implements Comparable<Estado> {

    private String sigla;
    private String nome;

    public Estado(String sigla, String nome) {
        Objects.requireNonNull(sigla);
        Objects.requireNonNull(nome);
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Estado estado = (Estado) object;
        return java.util.Objects.equals(sigla, estado.sigla);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), sigla);
    }

    @Override
    public int compareTo(Estado o) {
        return sigla.compareTo(o.getSigla());
    }
}
