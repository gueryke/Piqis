public class Mago extends Personagem {
    private String tipoMagia;
    
    public Mago(String nome, int nivel, int vida, String tipoMagia) {
        this.setNome(nome);
        this.setNivel(nivel);
        this.setVida(vida);
        this.tipoMagia = tipoMagia;
    }
    
    public String getTipoMagia() {
        return this.tipoMagia;
    }
    
    public void setTipoMagia(String tipoMagia) {
        this.tipoMagia = tipoMagia;
    }
    
    public void atacar() {
        if (this.estaVivo()) {
            System.out.println(this.getNome() + " lanca um feitico de " + this.tipoMagia + "!");
        } else {
            System.out.println(this.getNome() + " esta derrotado e nao pode atacar!");
        }
    }
    
    public void exibirInfo() {
        System.out.println("=== Informacoes do Mago ===");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Nivel: " + this.getNivel());
        System.out.println("Vida: " + this.getVida());
        System.out.println("Tipo de Magia: " + this.tipoMagia);
        if (this.estaVivo()) {
            System.out.println("Status: Vivo");
        } else {
            System.out.println("Status: Derrotado");
        }
    }
}