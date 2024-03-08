	public class operacoes {
    public static void main(String[] args) {
        
    	// Altere o valor de "numero" e "angulo" para número e ângulo desejados
    	double numero = 4.56;
        double angulo = Math.PI / 4; // 45 graus em radianos

        // Calcula a raiz quadrada do número informado anteriormente
        double raizQuadrada = Math.sqrt(numero);
        System.out.println("Raiz quadrada de " + numero + ": " + raizQuadrada);

        // Arredonda o número informado para cima (teto)
        double teto = Math.ceil(numero);
        System.out.println("Arredondado para cima: " + teto);

        // Arredonda um número informado para baixo (piso)
        double piso = Math.floor(numero);
        System.out.println("Arredondado para baixo: " + piso);

        // Calcula o valor absoluto do número informado
        double absoluto = Math.abs(numero);
        System.out.println("Valor absoluto de " + numero + ": " + absoluto);

        // Calcula o seno do ângulo informado no início
        double seno = Math.sin(angulo);
        System.out.println("Seno de " + angulo + " radianos: " + seno);

        // Calcula o cosseno do ângulo informado
        double cosseno = Math.cos(angulo);
        System.out.println("Cosseno de " + angulo + " radianos: " + cosseno);

        // Calcula a potência de um número, pode-se alterar as variáveis "base", "expoente" e "potencia" para obter a operação desejada
        double base = 6;
        double expoente = 3;
        double potencia = Math.pow(base, expoente);
        System.out.println(base + " elevado a " + expoente + ": " + potencia);

        // Gera um número aleatório dentro de um intervalo especificado, pode-se alterar esse intervalo alterando "min" e "max"
        int min = 500;
        int max = 10000;
        double numeroAleatorio = min + (Math.random() * (max - min));
        System.out.println("Número aleatório entre " + min + " e " + max + ": " + numeroAleatorio);
    }
}
