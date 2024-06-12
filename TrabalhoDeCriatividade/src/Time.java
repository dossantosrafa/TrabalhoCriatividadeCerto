import java.util.List;
import java.util.Objects;

public class Time {
    private String nome; // Nome do time
    private String cidade; // Cidade do time
    private List<Jogador> jogadores; // Lista de jogadores do time

    // Construtor para criar um time com nome, cidade e jogadores
    public Time(String nome, String cidade, List<Jogador> jogadores) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
    }

    // Getter para o nome do time
    public String getNome() {
        return nome;
    }

    // Getter para a cidade do time
    public String getCidade() {
        return cidade;
    }

    // Getter para a lista de jogadores
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    // Método para exibir informações do time em formato de string
    @Override
    public String toString() {
        return "Time [Nome=" + nome + ", Cidade=" + cidade + ", Jogadores=" + jogadores + "]";
    }

    // Método para comparar dois objetos Time
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Se os objetos são exatamente os mesmos
        if (o == null || getClass() != o.getClass()) return false; // Se o objeto é nulo ou não é da classe Time
        Time time = (Time) o; // Cast para o tipo Time
        return Objects.equals(nome, time.nome) && // Comparando nomes dos times
                Objects.equals(cidade, time.cidade) && // Comparando cidades dos times
                temOsMesmosJogadores(time); // Verificando se têm os mesmos jogadores
    }

    // Método privado para verificar se dois times têm os mesmos jogadores
    private boolean temOsMesmosJogadores(Time outroTime) {
        if (jogadores == null && outroTime.jogadores == null) return true; // Se ambos os times não têm jogadores
        if (jogadores == null || outroTime.jogadores == null) return false; // Se apenas um dos times não tem jogadores
        // Se o tamanho das listas de jogadores é o mesmo e todos os jogadores de um time estão no outro
        return jogadores.size() == outroTime.jogadores.size() && jogadores.containsAll(outroTime.jogadores);
    }
}
