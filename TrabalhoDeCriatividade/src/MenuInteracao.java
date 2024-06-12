import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuInteracao {

    public static void exibirMenu(List<Time> times) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Verificar jogador com mais gols");
                System.out.println("2. Listar jogadores de um time");
                System.out.println("3. Encontrar jogador mais velho");
                System.out.println("4. Comparar dois jogadores");
                System.out.println("5. Criar um novo time e adicionar jogadores");
                System.out.println("6. Adicionar jogador a um time existente");
                System.out.println("7. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        verificarJogadorComMaisGols(times);
                        break;
                    case 2:
                        listarJogadoresDeUmTime(times, scanner);
                        break;
                    case 3:
                        encontrarJogadorMaisVelho(times);
                        break;
                    case 4:
                        compararDoisJogadores(times, scanner);
                        break;
                    case 5:
                        criarTimeEAdicionarJogadores(times, scanner);
                        break;
                    case 6:
                        adicionarJogadorATimeExistente(times, scanner);
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro de entrada. Por favor, tente novamente.");
                scanner.nextLine();  // Consumir a nova linha para evitar loop infinito
            }
        }
    }

    private static void verificarJogadorComMaisGols(List<Time> times) {
        times.stream()
             .flatMap(time -> time.getJogadores().stream())
             .max((j1, j2) -> Integer.compare(j1.getGols(), j2.getGols()))
             .ifPresent(jogador -> System.out.println("Jogador com mais gols: " + jogador));
    }

    private static void listarJogadoresDeUmTime(List<Time> times, Scanner scanner) {
        System.out.println("Times disponíveis:");
        times.forEach(time -> System.out.println(time.getNome()));

        System.out.println("Digite o nome do time:");
        String nomeTime = scanner.nextLine();

        times.stream()
             .filter(time -> time.getNome().equalsIgnoreCase(nomeTime))
             .findFirst()
             .ifPresentOrElse(time -> {
                 System.out.println("Jogadores do " + time.getNome() + ":");
                 time.getJogadores().forEach(System.out::println);
             }, () -> System.out.println("Time não encontrado."));
    }

    private static void encontrarJogadorMaisVelho(List<Time> times) {
        times.stream()
             .flatMap(time -> time.getJogadores().stream())
             .max((j1, j2) -> Integer.compare(j1.getIdade(), j2.getIdade()))
             .ifPresent(jogador -> System.out.println("Jogador mais velho: " + jogador));
    }

    private static void compararDoisJogadores(List<Time> times, Scanner scanner) {
        List<Jogador> todosJogadores = times.stream()
                                            .flatMap(time -> time.getJogadores().stream())
                                            .collect(Collectors.toList());

        System.out.println("Jogadores disponíveis:");
        todosJogadores.forEach(jogador -> System.out.println(jogador.getNome()));

        System.out.println("Digite o nome do primeiro jogador para comparação:");
        String nomeJogador1 = scanner.nextLine();
        System.out.println("Digite o nome do segundo jogador para comparação:");
        String nomeJogador2 = scanner.nextLine();

        Jogador jogador1 = todosJogadores.stream()
                                         .filter(jogador -> jogador.getNome().equalsIgnoreCase(nomeJogador1))
                                         .findFirst()
                                         .orElse(null);

        Jogador jogador2 = todosJogadores.stream()
                                         .filter(jogador -> jogador.getNome().equalsIgnoreCase(nomeJogador2))
                                         .findFirst()
                                         .orElse(null);

        if (jogador1 != null && jogador2 != null) {
            System.out.println("Comparação entre " + jogador1.getNome() + " e " + jogador2.getNome() + ":");
            System.out.println("Idade: " + jogador1.getIdade() + " vs " + jogador2.getIdade());
            System.out.println("Gols: " + jogador1.getGols() + " vs " + jogador2.getGols());
            System.out.println("Posição: " + jogador1.getPosicao() + " vs " + jogador2.getPosicao());
        } else {
            System.out.println("Um ou ambos os jogadores não foram encontrados. Tente novamente.");
        }
    }

    private static void criarTimeEAdicionarJogadores(List<Time> times, Scanner scanner) {
        System.out.println("Digite o nome do novo time:");
        String nomeTime = scanner.nextLine();
        
        System.out.println("Digite a cidade do novo time:");
        String cidadeTime = scanner.nextLine();

        List<Jogador> jogadores = new ArrayList<>();
        while (true) {
            System.out.println("Deseja adicionar um jogador ao time? (sim/nao)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("nao")) {
                break;
            }

            System.out.println("Digite o nome do jogador:");
            String nomeJogador = scanner.nextLine();
            System.out.println("Digite a idade do jogador:");
            int idadeJogador = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha
            System.out.println("Digite a posição do jogador:");
            String posicaoJogador = scanner.nextLine();
            System.out.println("Digite o número de gols do jogador:");
            int golsJogador = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            Jogador jogador = new Jogador(nomeJogador, idadeJogador, posicaoJogador, golsJogador);
            jogadores.add(jogador);
        }

        Time novoTime = new Time(nomeTime, cidadeTime, jogadores);
        times.add(novoTime);
        System.out.println("Time " + nomeTime + " criado com sucesso!");
    }

    private static void adicionarJogadorATimeExistente(List<Time> times, Scanner scanner) {
        System.out.println("Times disponíveis:");
        times.forEach(time -> System.out.println(time.getNome()));

        System.out.println("Digite o nome do time ao qual deseja adicionar um jogador:");
        String nomeTime = scanner.nextLine();

        Time time = times.stream()
                         .filter(t -> t.getNome().equalsIgnoreCase(nomeTime))
                         .findFirst()
                         .orElse(null);

        if (time != null) {
            System.out.println("Digite o nome do jogador:");
            String nomeJogador = scanner.nextLine();
            System.out.println("Digite a idade do jogador:");
            int idadeJogador = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha
            System.out.println("Digite a posição do jogador:");
            String posicaoJogador = scanner.nextLine();
            System.out.println("Digite o número de gols do jogador:");
            int golsJogador = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            Jogador jogador = new Jogador(nomeJogador, idadeJogador, posicaoJogador, golsJogador);
            time.getJogadores().add(jogador);
            System.out.println("Jogador " + nomeJogador + " adicionado ao time " + nomeTime + " com sucesso!");
        } else {
            System.out.println("Time não encontrado.");
        }
    }
}
