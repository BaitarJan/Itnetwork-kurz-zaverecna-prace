package cviceni;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("--- Evidence pojištěných ---");
            System.out.println("1 - Přidat pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            System.out.println("5 - Naplnit databázi 20 náhodnými pojištěnými");
            System.out.print("Vyberte volbu: ");

            String volba = scanner.nextLine().trim();

            switch (volba) {
                case "1": {
                    // Zadání jména
                    String jmeno;
                    do {
                        System.out.print("Zadejte jméno: ");
                        jmeno = scanner.nextLine().trim();
                        if (jmeno.isEmpty()) {
                            System.out.println("Jméno nesmí být prázdné.");
                        }
                    } while (jmeno.isEmpty());

                    // Zadání příjmení
                    String prijmeni;
                    do {
                        System.out.print("Zadejte příjmení: ");
                        prijmeni = scanner.nextLine().trim();
                        if (prijmeni.isEmpty()) {
                            System.out.println("Příjmení nesmí být prázdné.");
                        }
                    } while (prijmeni.isEmpty());

                    // Zadání věku
                    int vek = -1;
                    do {
                        System.out.print("Zadejte věk: ");
                        String vekStr = scanner.nextLine().trim();
                        try {
                            vek = Integer.parseInt(vekStr);
                            if (vek < 0 || vek > 150) {
                                System.out.println("Neplatný věk (0-150).");
                                vek = -1; // reset pro cyklus
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Neplatný vstup pro věk!");
                        }
                    } while (vek == -1);

                    // Zadání telefonu
                    String telefon;
                    do {
                        System.out.print("Zadejte telefon: ");
                        telefon = scanner.nextLine().trim();
                        if (telefon.isEmpty()) {
                            System.out.println("Telefon nesmí být prázdný.");
                        }
                    } while (telefon.isEmpty());

                    // Přidání pojištěného
                    Pojistenec p = new Pojistenec(jmeno, prijmeni, telefon, vek);
                    evidence.pridej(p);
                    System.out.println("Pojištěný přidán.");
                    break;
                }

                case "2":
                    ArrayList<Pojistenec> seznam = evidence.getAll();
                    int cislo = 1;
                    for (Pojistenec a : seznam) {
                        System.out.println(cislo + ") " + a);
                    cislo++;
                    }
                    break;

                case "3":
                    System.out.print("Zadejte jméno (Enter = ignorovat): ");
                    String hledaneJmeno = scanner.nextLine().trim();
                    System.out.print("Zadejte příjmení (Enter = ignorovat): ");
                    String hledanePrijmeni = scanner.nextLine().trim();

                    ArrayList<Pojistenec> vysledek = evidence.vyhledej(hledaneJmeno, hledanePrijmeni);
                    if (vysledek.isEmpty()) {
                        System.out.println("Pojištěný nenalezen.");
                    } else {
                        int cisloVysledek = 1;
                        for (Pojistenec a : vysledek) {
                            System.out.println(cisloVysledek + ") " + a);
                            cisloVysledek++;
                        }
                    }
                    break;

                case "4":
                    System.out.println("Konec aplikace.");
                    scanner.close();

                    return;

                case "5": {
                    System.out.println("Naplnění databáze 20 náhodnými pojištěnými...");
                    for (int i = 0; i < 20; i++) {
                        String jmeno = GeneratorJmen.nahodneJmeno();
                        String prijmeni = GeneratorJmen.nahodnePrijmeni();
                        int vek = GeneratorJmen.nahodnyVek();
                        String telefon = GeneratorJmen.nahodnyTelefon();

                        Pojistenec p = new Pojistenec(jmeno, prijmeni, telefon, vek);
                        evidence.pridej(p);
                    }
                    System.out.println("Databáze naplněna.");
                    break;
                }


                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }
}