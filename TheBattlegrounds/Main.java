import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BATALHA RPG - 2 JOGADORES ===\n");

        Personagem p1 = criarPersonagem(scanner, "Jogador 1");
        System.out.println();
        Personagem p2 = criarPersonagem(scanner, "Jogador 2");

        System.out.println("\n=== A BATALHA COMECA! ===");
        System.out.println(p1.getNome() + " VS " + p2.getNome());
        System.out.println("Pressione ENTER para comecar...");
        scanner.nextLine();

        Personagem atacante = p1;
        Personagem defensor = p2;
        int turno = 1;

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n===== TURNO " + turno + " =====");
            System.out.println("Vez de " + atacante.getNome() + "!");
            jogarTurno(scanner, atacante, defensor);

            if (!defensor.estaVivo()) {
                System.out.println("\n" + defensor.getNome() + " foi derrotado!");
                System.out.println(">>> " + atacante.getNome() + " VENCEU A BATALHA! <<<");
                break;
            }

            // troca os papeis
            Personagem temp = atacante;
            atacante = defensor;
            defensor = temp;

            turno++;
        }

        System.out.println("\n=== FIM DA BATALHA ===");
        p1.exibirInfo();
        System.out.println();
        p2.exibirInfo();

        scanner.close();
    }

    public static Personagem criarPersonagem(Scanner scanner, String jogador) {
        System.out.println("--- " + jogador + ", escolha seu personagem ---");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.print("Opcao: ");

        int opcao = lerInteiro(scanner);

        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();

        if (opcao == 1) {
            System.out.print("Digite o nome da arma: ");
            String arma = scanner.nextLine();
            System.out.println(jogador + " criou o guerreiro " + nome + "!");
            return new Guerreiro(nome, 1, 100, arma);
        } else {
            System.out.print("Digite o tipo de magia: ");
            String magia = scanner.nextLine();
            System.out.println(jogador + " criou o mago " + nome + "!");
            return new Mago(nome, 1, 100, magia);
        }
    }

    public static void jogarTurno(Scanner scanner, Personagem atacante, Personagem defensor) {
        boolean acaoFeita = false;

        while (!acaoFeita) {
            System.out.println("\n--- Menu de " + atacante.getNome() + " ---");
            System.out.println("1 - Atacar");
            System.out.println("2 - Tomar pocao (restam " + atacante.getPocoes() + ")");
            System.out.println("3 - Ver status");
            System.out.print("Escolha: ");

            int opcao = lerInteiro(scanner);

            if (opcao == 1) {
                atacante.atacar();
                defensor.receberDano(atacante.getDanoAtaque());
                acaoFeita = true;
            } else if (opcao == 2) {
                if (atacante.tomarPocao()) {
                    acaoFeita = true;
                }
            } else if (opcao == 3) {
                atacante.exibirInfo();
                defensor.exibirInfo();
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    public static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um numero valido: ");
            scanner.nextLine();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa o ENTER
        return valor;
    }
}