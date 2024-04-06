package animaisPOO;

class Peixe extends Animal {
    private String caracteristica;

    public Peixe(String nome, double comprimento, int numDePatas, String cor, String ambiente, double velocidadeMedia, String caracteristica) {
        super(nome, comprimento, numDePatas, ambiente, velocidadeMedia, cor);
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return super.toString() + ", Característica: " + caracteristica;
    }

    // Getter e Setter
    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
}

