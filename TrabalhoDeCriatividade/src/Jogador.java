public class Jogador {
    // Armazena o nome do jogador
    private String nome;
    // Armazena a idade do jogador
    private int idade;
    // Armazena a posição do jogador em campo
    private String posicao;
    // Armazena o número de gols que o jogador fez
    private int gols;

    // Construtor para criar um novo jogador com os dados fornecidos
    public Jogador(String nome, int idade, String posicao, int gols) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.gols = gols;
    }

    // Pega o nome do jogador
    public String getNome() {
        return nome;
    }

    // Pega a idade do jogador
    public int getIdade() {
        return idade;
    }

    // Pega a posição do jogador
    public String getPosicao() {
        return posicao;
    }

    // Pega o número de gols do jogador
    public int getGols() {
        return gols;
    }

    // Retorna uma string com todos os detalhes do jogador
    @Override
    public String toString() {
        return "Jogador [Nome=" + nome + ", Idade=" + idade + ", Posição=" + posicao + ", Gols=" + gols + "]";
    }
}
