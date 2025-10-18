package cviceni;
import java.util.Random;

public class GeneratorJmen {

    private static String[] jmena = {
            "Jan", "Petr", "Eva", "Lucie", "Martin",
            "Anna", "Karel", "Simona", "Marek", "Petra",
            "Tomas", "Jana", "Michal", "David", "Veronika",
            "Roman", "Jakub", "Martina", "Lenka", "Filip"
    };

    private static String[] prijmeni = {
            "Novak", "Svoboda", "Kralova", "Horakova", "Dvorak",
            "Bila", "Cerny", "Zelenka", "Modry", "Ruzova",
            "Havlik", "Novotna", "Krejci", "Horak", "Buresova",
            "Fialova", "Svoboda", "Bila", "Kral", "Hrdlicka"
    };

    private static Random random = new Random();

    public static String nahodneJmeno() {
        return jmena[random.nextInt(jmena.length)];
    }

    public static String nahodnePrijmeni() {
        return prijmeni[random.nextInt(prijmeni.length)];
    }

    public static int nahodnyVek() {
        return 20 + random.nextInt(50); // věk od 20 do 69
    }

    public static String nahodnyTelefon() {
        return String.format("7%08d", random.nextInt(100000000)); // české číslo
    }
}