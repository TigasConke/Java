package animaisPOO;

public class TestarAnimais {
    public static void main(String[] args) {
        Mamifero camelo = new Mamifero("Camelo", 150, 4, "Terra", 2.0, "Amarelo", "vegetais");
        Peixe tubarao = new Peixe("Tubarão", 300, 0, "Cinzento", "Mar", 1.5, "Barbatanas e cauda");
        Mamifero ursoCanada = new Mamifero("Urso-do-canadá", 180, 4, "Terra", 0.5, "Vermelho", "Mel");

        System.out.println(camelo);
        System.out.println(tubarao);
        System.out.println(ursoCanada);

        // Polimorfismo
        Animal[] animais = { camelo, tubarao, ursoCanada };
        for (Animal animal : animais) {
            System.out.println(animal);
        }
    }
}
