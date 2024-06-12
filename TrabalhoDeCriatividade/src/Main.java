import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Inicializando os jogadores
        Jogador jogador1 = new Jogador("Cassio", 30, "Goleiro", 69);
        Jogador jogador2 = new Jogador("Ze Ivaldo", 26, "Zagueiro", 9);
        Jogador jogador3 = new Jogador("João Marcelo", 23, "Zagueiro", 12);
        Jogador jogador4 = new Jogador("Marlon", 25, "Lateral Esquerdo", 16);
        Jogador jogador5 = new Jogador("William", 27, "Lateral Direito", 8);
        Jogador jogador6 = new Jogador("Lucas Romero", 28, "Volante", 9);
        Jogador jogador7 = new Jogador("Lucas Silva", 32, "Volante", 8);
        Jogador jogador8 = new Jogador("Matheus Pereira", 28, "Meio campo", 100);
        Jogador jogador9 = new Jogador("Juan Dinneno", 28, "Atacante", 20);
        Jogador jogador10 = new Jogador("Barreal", 29, "Ponta Esquerda", 31);
        Jogador jogador11 = new Jogador("Lionel Messi", 36, "Ponta Direita", 936);

        Jogador jogador12 = new Jogador("Everton", 32, "Goleiro", 1);
        Jogador jogador13 = new Jogador("Ruben Dias", 29, "Zagueiro", 9);
        Jogador jogador14 = new Jogador("Akanji", 23, "Zagueiro", 12);
        Jogador jogador15 = new Jogador("Walker", 26, "Lateral Direito", 15);
        Jogador jogador16 = new Jogador("Ake", 22, "Lateral Esquerdo", 13);
        Jogador jogador17 = new Jogador("Rodri", 31, "Volante", 7);
        Jogador jogador18 = new Jogador("Bernardo Silva", 29, "Meia Campo", 98);
        Jogador jogador19 = new Jogador("De Bruyne", 30, "Meia Campo", 53);
        Jogador jogador20 = new Jogador("Haalland", 23, "Atacante", 75);
        Jogador jogador21 = new Jogador("Grealish", 25, "Ponta Esquerda", 28);
        Jogador jogador22 = new Jogador("Foden", 22, "Ponta Direita", 69);

        // Fazendo duas listas de jogadores, um para cada time
        List<Jogador> jogadoresTimeA = Arrays.asList(jogador1, jogador2, jogador3, jogador4, jogador5, jogador6, jogador7, jogador8, jogador9, jogador10, jogador11);
        List<Jogador> jogadoresTimeB = Arrays.asList(jogador12, jogador13, jogador14, jogador15, jogador16, jogador17, jogador18, jogador19, jogador20, jogador21, jogador22);

        // Inicializando os times com suas listas de jogadores
        Time time1 = new Time("Cruzeiro", "Belo Horizonte", jogadoresTimeA);
        Time time2 = new Time("Manchester City", "Manchester", jogadoresTimeB);

        // Colocando os times numa lista
        List<Time> times = new ArrayList<>(Arrays.asList(time1, time2));

        // Chamando o menu de interação
        MenuInteracao.exibirMenu(times);
    }
}
