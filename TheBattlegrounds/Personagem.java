public class Personagem {
    private String nome;
    private int nivel;
    private int vida;
    private int pocoes;
    private int danoAtaque;

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
        this.pocoes = 3;
        this.danoAtaque = 10;
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

    public int getPocoes() {
        return this.pocoes;
    }

    public int getDanoAtaque() {
        return this.danoAtaque;
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

    public void setPocoes(int pocoes) {
        if (pocoes >= 0) {
            this.pocoes = pocoes;
        }
    }

    public void setDanoAtaque(int danoAtaque) {
        if (danoAtaque > 0) {
            this.danoAtaque = danoAtaque;
        }
    }

    public void atacar() {
        if (this.estaVivo()) {
            System.out.println(this.nome + " realiza um ataque básico!");
        } else {
            System.out.println(this.nome + " foi derrotado e não pode mais atacar");
        }
    }

    public boolean tomarPocao() {
        if (!this.estaVivo()) {
            System.out.println(this.nome + " não pode tomar poção porque está derrotado!");
            return false;
        }

        if (this.pocoes <= 0) {
            System.out.println(this.nome + " não tem poções restantes!");
            return false;
        }

        int cura = 25;
        int vidaAntes = this.vida;
        this.vida = Math.min(100, this.vida + cura);
        this.pocoes--;

        System.out.println(this.nome + " usou uma poção e recuperou " + (this.vida - vidaAntes) + " de vida.");
        System.out.println("Vida atual: " + this.vida + " | Poções restantes: " + this.pocoes);
        return true;
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
        return this.vida > 0;
    }

    public boolean estaDerrotado() {
        return this.vida == 0;
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