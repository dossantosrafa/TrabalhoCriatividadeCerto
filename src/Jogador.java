public class Jogador {
    private String nome;
    private int idade;
    private String posicao;
    private int gols;

    public Jogador(String nome, int idade, String posicao, int gols) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.gols = gols;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getGols() {
        return gols;
    }

    @Override
    public String toString() {
        return "Jogador [Nome=" + nome + ", Idade=" + idade + ", Posição=" + posicao + ", Gols=" + gols + "]";
    }
}
