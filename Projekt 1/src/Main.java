import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Kilo angeben: ");
        double kiloInput = scanner.nextDouble();
        System.out.println("Bitte Preis pro Kilo angeben: ");
        double pricePerKg = scanner.nextDouble();
        double bruttoPrice = kiloInput * pricePerKg;


        if (kiloInput >= 10 && kiloInput < 50) {
            double prozent10 = kiloInput / 100 * 10;
            double summe = bruttoPrice - prozent10;
            System.out.println("Preis ohne Rabatt: " + bruttoPrice);
            System.out.println("Rabatt: 10%");
            System.out.println("Differenz: " + prozent10);
            System.out.println("Summe: " + summe);
        } else if (kiloInput >= 50) {
            double prozent20 = kiloInput / 100 * 20;
            double summe = bruttoPrice - prozent20;
            System.out.println("Preis ohne Rabatt: " + bruttoPrice);
            System.out.println("Rabatt: 20%");
            System.out.println("Differenz: " + prozent20);
            System.out.println("Summe: " + summe);
        } else {
            System.out.println("Preis ohne Rabatt: " + bruttoPrice);
        }

    }
}