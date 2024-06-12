import java.util.List;
import java.util.Objects;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogador> jogadores;

    public Time(String nome, String cidade, List<Jogador> jogadores) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public String toString() {
        return "Time [Nome=" + nome + ", Cidade=" + cidade + ", Jogadores=" + jogadores + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(nome, time.nome) &&
                Objects.equals(cidade, time.cidade) &&
                temOsMesmosJogadores(time);
    }

    private boolean temOsMesmosJogadores(Time outroTime) {
        if (jogadores == null && outroTime.jogadores == null) return true;
        if (jogadores == null || outroTime.jogadores == null) return false;
        return jogadores.size() == outroTime.jogadores.size() && jogadores.containsAll(outroTime.jogadores);
    }
}
