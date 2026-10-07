public class Personagem {
    private String nome;
    private int nivel;
    private int vida;
    
    public Personagem(String nome, int nivel, int vida) {
        this.nome = nome;
        if (nivel > 0) {
            this.nivel = nivel;
        } else {
            this.nivel = 1;
        }
        if (vida > 0) {
            this.vida = vida;
        } else {
            this.vida = 100;
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getNivel() {
        return this.nivel;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }
    
    public void setVida(int vida) {
        if (vida >= 0) {
            this.vida = vida;
        } else {
            this.vida = 0;
        }
    }
    
    public void atacar() {
        if (this.estaVivo()) {
            System.out.println(this.nome + " realiza um ataque basico!");
        } else {
            System.out.println(this.nome + " esta derrotado e nao pode atacar!");
        }
    }
    
    public void receberDano(int dano) {
        if (dano > 0) {
            this.vida = this.vida - dano;
            if (this.vida < 0) {
                this.vida = 0;
            }
            System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
        } else {
            System.out.println("Dano invalido! Nenhum dano foi causado.");
        }
    }
    
    public boolean estaVivo() {
        if (this.vida > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean estaDerrotado() {
        if (this.vida == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void exibirInfo() {
        System.out.println("=== Informacoes do Personagem ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Vida: " + this.vida);
        if (this.estaVivo()) {
            System.out.println("Status: Vivo");
        } else {
            System.out.println("Status: Derrotado");
        }
    }
}