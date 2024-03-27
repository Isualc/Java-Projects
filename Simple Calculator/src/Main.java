/**
 * KLASSENHEADER
 * Name Claus Hierzer
 * Datum 14.09.2023
 * Version 20.002git
 * Beschreibung
 *The programm calculate the Break-Even-Point, the performance, the earnings and costs of a PV-System.
 *
 */
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Zahl1 eingeben: ");
        int zahl1 = scanner.nextInt();

        System.out.print("Bitte Zahl2 eingeben: ");
        int zahl2 = scanner.nextInt();

        System.out.print("Bitte Operator +, -, * oder / eingeben: ");
        String operation = scanner.next();

        double result = 0;

        if (operation.equals("+")){
            result = zahl1 + zahl2;
        } else if (operation.equals("-")) {
            result = zahl1 - zahl2;
        } else if (operation.equals("*")) {
            result = zahl1 * zahl2;
        } else if (operation.equals("/")) {
            if (zahl2 != 0) {
                 result = zahl1 / zahl2;
            } else {
                System.out.println("!!!ACHTUNG!!! Eine Division durch 0 ist nicht möglich!");
                return;
            }
        } else {
            System.out.println("Ungültige Operation");
            return;
        }
        System.out.println("Ergebnis: " + result);
    }
}