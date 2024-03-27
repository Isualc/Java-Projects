/**
 * KLASSENHEADER
 *Claus Hierzer
 *15.09.2023
 *Version 20.002
 */

public class LoopsUebung {
    public static void main(String[] args) {

        for (int zahl1 = 1; zahl1 <= 10; zahl1++) {
            for (int zahl2 = 1; zahl2 <= 10; zahl2++) {
                int ergebnis = zahl1 * zahl2;
                    System.out.println(zahl1 + " x " + zahl2 + " = " + ergebnis);
            }
            System.out.println();
        }
    }
}
