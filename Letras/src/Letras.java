
public class Letras {
    public static void main(String[] args) {
        // Escreva uma frase para atribuir a string "texto"
        String texto = "Uma frase criativa aqui.";

        // Verifica o comprimento da string
        int comprimento = texto.length();
        System.out.println("Comprimento da string: " + comprimento);

        // Converte a string para maiúsculas
        String maiusculas = texto.toUpperCase();
        System.out.println("String em maiúsculas: " + maiusculas);

        // Converte a string para minúsculas
        String minusculas = texto.toLowerCase();
        System.out.println("String em minúsculas: " + minusculas);

        // Verifiqua se a string contém uma determinada sequência de caracteres, pode-se alterar o que será atribuído a variável "sequencia"
        String sequencia = "criativa";
        boolean contem = texto.contains(sequencia);
        System.out.println("A string contém a sequência '" + sequencia + "'? " + contem);

        // Extrai uma parte específica da string, pode-se determinar o início e o fim da extração, alterando as variáveis "inicio" e fim"
        int inicio = 0;
        int fim = 19;
        String parte = texto.substring(inicio, fim);
        System.out.println("Parte específica da string: " + parte);

        // Substitui uma parte da string por outra sequência de caracteres, pode-se alterar o que será substituído aletrando "texto.replace()"
        String novaString = texto.replace("criativa", "clichê");
        System.out.println("String com substituição: " + novaString);

     // Divide a string em substrings por palavra
        String[] palavras = texto.split(" ");
        System.out.println("String dividida por palavras:");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
    }
}
