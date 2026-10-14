public class Guerreiro extends Personagem {
    private String arma;

    public Guerreiro(String nome, int nivel, int vida, String arma) {
        super(nome, nivel, vida);
        this.arma = arma;
        this.setDanoAtaque(18);
    }

    public String getArma() {
        return this.arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void atacar() {
        if (this.estaVivo()) {
            System.out.println(this.getNome() + " ataca com " + this.arma + "!");
        } else {
            System.out.println(this.getNome() + " esta derrotado e nao pode atacar!");
        }
    }

    public void exibirInfo() {
        System.out.println("=== Informacoes do Guerreiro ===");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Nivel: " + this.getNivel());
        System.out.println("Vida: " + this.getVida());
        System.out.println("Arma: " + this.arma);
        if (this.estaVivo()) {
            System.out.println("Status: Vivo");
        } else {
            System.out.println("Status: Derrotado");
        }
    }
}