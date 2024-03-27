import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int randomNumber = rand.nextInt(101);
        int maxAttemts = 3;

        for (int attempt = 1; attempt <= maxAttemts; attempt++) {
            System.out.println("Bitte Zahl eingeben: ");
            Scanner scanner = new Scanner(System.in);
            int guessedNumber = scanner.nextInt();


            if (randomNumber == guessedNumber) {
                System.out.println("You Win!!!");
                break;
            } else if (guessedNumber < randomNumber) {
                System.out.println("Die gesuchte Zahl ist größer als " + guessedNumber + "!");
            } else {
                System.out.println("Die gesuchte Zahl ist kleiner als " + guessedNumber + "!");
            }
            if (attempt == maxAttemts) {
                System.out.println("Du hast alle Versuche verbraucht!!!");
            }
        }
    }
}