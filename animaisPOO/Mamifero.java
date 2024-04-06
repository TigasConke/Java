package animaisPOO;

class Mamifero extends Animal {
    private String alimento;

    public Mamifero(String nome, double comprimento, int numDePatas, String ambiente, double velocidadeMedia, String cor, String alimento) {
        super(nome, comprimento, numDePatas, ambiente, velocidadeMedia, cor);
        this.alimento = alimento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Alimento: " + alimento;
    }
 // Getter e Setter
    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
}
