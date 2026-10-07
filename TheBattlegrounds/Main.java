public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Personagens RPG ===\n");
        
        // RF01, RF02 - Cadastrar Guerreiro
        Guerreiro guerreiro = new Guerreiro("Thorin", 5, 100, "Espada Longa");
        System.out.println("Guerreiro criado com sucesso!");
        
        // RF01, RF03 - Cadastrar Mago
        Mago mago = new Mago("Gandalf", 10, 80, "Fogo");
        System.out.println("Mago criado com sucesso!\n");
        
        // RF04 - Consultar personagens
        guerreiro.exibirInfo();
        System.out.println();
        mago.exibirInfo();
        System.out.println();
        
        // RF05, RF06, RF07 - Realizar ataques
        System.out.println("=== Combate ===");
        guerreiro.atacar();
        mago.atacar();
        System.out.println();
        
        // RF08, RF09 - Receber dano e atualizar vida
        System.out.println("=== Dano Recebido ===");
        guerreiro.receberDano(30);
        mago.receberDano(25);
        System.out.println();
        
        // RF10 - Verificar situacao
        System.out.println("=== Status Atual ===");
        if (guerreiro.estaVivo()) {
            System.out.println(guerreiro.getNome() + " esta vivo!");
        }
        if (mago.estaVivo()) {
            System.out.println(mago.getNome() + " esta vivo!");
        }
        System.out.println();
        
        // RF11 - Simular batalha
        System.out.println("=== Simulacao de Batalha ===");
        batalhar(guerreiro, mago);
    }
    
    // Metodo para simular batalha
    public static void batalhar(Personagem p1, Personagem p2) {
        int turno = 1;
        
        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            
            // P1 ataca P2
            if (p1.estaVivo()) {
                p1.atacar();
                p2.receberDano(20);
            }
            
            // Verifica se P2 ainda esta vivo
            if (p2.estaDerrotado()) {
                System.out.println(p2.getNome() + " foi derrotado!");
                System.out.println(p1.getNome() + " venceu a batalha!");
                break;
            }
            
            // P2 ataca P1
            if (p2.estaVivo()) {
                p2.atacar();
                p1.receberDano(15);
            }
            
            // Verifica se P1 ainda esta vivo
            if (p1.estaDerrotado()) {
                System.out.println(p1.getNome() + " foi derrotado!");
                System.out.println(p2.getNome() + " venceu a batalha!");
                break;
            }
            
            turno++;
            
            // Limite de turnos para evitar loop infinito
            if (turno > 10) {
                System.out.println("\nBatalha encerrada apos 10 turnos!");
                break;
            }
        }
        
        System.out.println("\n=== Fim da Batalha ===");
        p1.exibirInfo();
        System.out.println();
        p2.exibirInfo();
    }
}