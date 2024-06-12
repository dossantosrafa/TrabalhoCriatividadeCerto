import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuInteracao {

    public static void exibirMenu(List<Time> times) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Exibindo o menu de opções
                System.out.println("Menu:");
                System.out.println("1. Verificar jogador com mais gols");
                System.out.println("2. Listar jogadores de um time");
                System.out.println("3. Encontrar jogador mais velho");
                System.out.println("4. Comparar dois jogadores");
                System.out.println("5. Criar um novo time e adicionar jogadores");
                System.out.println("6. Adicionar jogador a um time existente");
                System.out.println("7. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Limpando o buffer

                switch (opcao) {
                    case 1:
                        verificarJogadorComMaisGols(times);  // Chama o método que encontra o jogador com mais gols
                        break;
                    case 2:
                        listarJogadoresDeUmTime(times, scanner);  // Chama o método que lista jogadores de um time específico
                        break;
                    case 3:
                        encontrarJogadorMaisVelho(times);  // Chama o método que encontra o jogador mais velho
                        break;
                    case 4:
                        compararDoisJogadores(times, scanner);  // Chama o método que compara dois jogadores
                        break;
                    case 5:
                        criarTimeEAdicionarJogadores(times, scanner);  // Chama o método que cria um novo time e adiciona jogadores
                        break;
                    case 6:
                        adicionarJogadorATimeExistente(times, scanner);  // Chama o método que adiciona jogador a um time existente
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        scanner.close();  // Fecha o scanner
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");  // Opção inválida no menu
                }
            } catch (Exception e) {
                System.out.println("Erro de entrada. Por favor, tente novamente.");  // Erro na entrada de dados
                scanner.nextLine();  // Limpando o buffer para evitar loop infinito
            }
        }
    }

    // Método para encontrar o jogador com mais gols
    private static void verificarJogadorComMaisGols(List<Time> times) {
        times.stream()
             .flatMap(time -> time.getJogadores().stream())  // Transformando a lista de times em uma lista de jogadores
             .max((j1, j2) -> Integer.compare(j1.getGols(), j2.getGols()))  // Encontrando o jogador com mais gols
             .ifPresent(jogador -> System.out.println("Jogador com mais gols: " + jogador));  // Mostrando o jogador com mais gols
    }

    // Método para listar jogadores de um time específico
    private static void listarJogadoresDeUmTime(List<Time> times, Scanner scanner) {
        System.out.println("Times disponíveis:");
        times.forEach(time -> System.out.println(time.getNome()));  // Mostrando a lista de times disponíveis

        System.out.println("Digite o nome do time:");
        String nomeTime = scanner.nextLine();

        times.stream()
             .filter(time -> time.getNome().equalsIgnoreCase(nomeTime))  // Filtrando o time pelo nome
             .findFirst()
             .ifPresentOrElse(time -> {
                 System.out.println("Jogadores do " + time.getNome() + ":");
                 time.getJogadores().forEach(System.out::println);  // Listando os jogadores do time encontrado
             }, () -> System.out.println("Time não encontrado."));  // Mensagem caso o time não seja encontrado
    }

    // Método para encontrar o jogador mais velho
    private static void encontrarJogadorMaisVelho(List<Time> times) {
        times.stream()
             .flatMap(time -> time.getJogadores().stream())  // Transformando a lista de times em uma lista de jogadores
             .max((j1, j2) -> Integer.compare(j1.getIdade(), j2.getIdade()))  // Encontrando o jogador mais velho
             .ifPresent(jogador -> System.out.println("Jogador mais velho: " + jogador));  // Mostrando o jogador mais velho
    }

    // Método para comparar dois jogadores
    private static void compararDoisJogadores(List<Time> times, Scanner scanner) {
        List<Jogador> todosJogadores = times.stream()
                                            .flatMap(time -> time.getJogadores().stream())
                                            .collect(Collectors.toList());  // Coletando todos os jogadores em uma lista

        System.out.println("Jogadores disponíveis:");
        todosJogadores.forEach(jogador -> System.out.println(jogador.getNome()));  // Mostrando a lista de todos os jogadores

        System.out.println("Digite o nome do primeiro jogador para comparação:");
        String nomeJogador1 = scanner.nextLine();
        System.out.println("Digite o nome do segundo jogador para comparação:");
        String nomeJogador2 = scanner.nextLine();

        // Encontrando o primeiro jogador
        Jogador jogador1 = todosJogadores.stream()
                                         .filter(jogador -> jogador.getNome().equalsIgnoreCase(nomeJogador1))
                                         .findFirst()
                                         .orElse(null);

        // Encontrando o segundo jogador
        Jogador jogador2 = todosJogadores.stream()
                                         .filter(jogador -> jogador.getNome().equalsIgnoreCase(nomeJogador2))
                                         .findFirst()
                                         .orElse(null);

        if (jogador1 != null && jogador2 != null) {
            // Mostrando a comparação entre os dois jogadores
            System.out.println("Comparação entre " + jogador1.getNome() + " e " + jogador2.getNome() + ":");
            System.out.println("Idade: " + jogador1.getIdade() + " vs " + jogador2.getIdade());
            System.out.println("Gols: " + jogador1.getGols() + " vs " + jogador2.getGols());
            System.out.println("Posição: " + jogador1.getPosicao() + " vs " + jogador2.getPosicao());
        } else {
            System.out.println("Um ou ambos os jogadores não foram encontrados. Tente novamente.");  // Mensagem caso algum jogador não seja encontrado
        }
    }

    // Método para criar um novo time e adicionar jogadores a ele
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
                break;  // Sai do loop se a resposta for "não"
            }

            // Coletando os dados do novo jogador
            System.out.println("Digite o nome do jogador:");
            String nomeJogador = scanner.nextLine();
            System.out.println("Digite a idade do jogador:");
            int idadeJogador = scanner.nextInt();
            scanner.nextLine();  // Limpando o buffer
            System.out.println("Digite a posição do jogador:");
            String posicaoJogador = scanner.nextLine();
            System.out.println("Digite o número de gols do jogador:");
            int golsJogador = scanner.nextInt();
            scanner.nextLine();  // Limpando o buffer

            // Criando um novo jogador e adicionando à lista de jogadores
            Jogador jogador = new Jogador(nomeJogador, idadeJogador, posicaoJogador, golsJogador);
            jogadores.add(jogador);
        }

        // Criando um novo time com a lista de jogadores coletada
        Time novoTime = new Time(nomeTime, cidadeTime, jogadores);
        times.add(novoTime);  // Adicionando o novo time à lista de times
        System.out.println("Time " + nomeTime + " criado com sucesso!");
    }

    // Método para adicionar um jogador a um time existente
    private static void adicionarJogadorATimeExistente(List<Time> times, Scanner scanner) {
        System.out.println("Times disponíveis:");
        times.forEach(time -> System.out.println(time.getNome()));  // Mostrando a lista de times disponíveis

        System.out.println("Digite o nome do time ao qual deseja adicionar um jogador:");
        String nomeTime = scanner.nextLine();

        // Encontrando o time pelo nome
        Time time = times.stream()
                         .filter(t -> t.getNome().equalsIgnoreCase(nomeTime))
                         .findFirst()
                         .orElse(null);

        if (time != null) {
            // Coletando os dados do novo jogador
            System.out.println("Digite o nome do jogador:");
            String nomeJogador = scanner.nextLine();
            System.out.println("Digite a idade do jogador:");
            int idadeJogador = scanner.nextInt();
            scanner.nextLine();  // Limpando o buffer
            System.out.println("Digite a posição do jogador:");
            String posicaoJogador = scanner.nextLine();
            System.out.println("Digite o número de gols do jogador:");
            int golsJogador = scanner.nextInt();
            scanner.nextLine();  // Limpando o buffer

            // Criando um novo jogador e adicionando ao time encontrado
            Jogador jogador = new Jogador(nomeJogador, idadeJogador, posicaoJogador, golsJogador);
            time.getJogadores().add(jogador);
            System.out.println("Jogador " + nomeJogador + " adicionado ao time " + nomeTime + " com sucesso!");
        } else {
            System.out.println("Time não encontrado.");  // Mensagem caso o time não seja encontrado
        }
    }
}
