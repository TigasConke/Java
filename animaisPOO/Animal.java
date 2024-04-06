package animaisPOO;

class Animal {
    private String nome;
    private double comprimento;
    private int numDePatas;
    private String ambiente;
    private double velocidadeMedia;
    private String cor;

    public Animal(String nome, double comprimento, int numDePatas, String ambiente, double velocidadeMedia, String cor) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.numDePatas = numDePatas;
        this.ambiente = ambiente;
        this.velocidadeMedia = velocidadeMedia;
        this.cor = cor;
    }

    public String toString() {
        return "Nome: " + nome + ", Comprimento: " + comprimento + ", Número de Patas: " + numDePatas +
                ", Ambiente: " + ambiente + ", Velocidade Média: " + velocidadeMedia + " Cor: " + cor;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public int getNumDePatas() {
        return numDePatas;
    }

    public void setNumDePatas(int numDePatas) {
        this.numDePatas = numDePatas;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public String getCor() {
        return cor;
    } 

    public void setCor(String cor) {
        this.cor = cor;
    } 
}