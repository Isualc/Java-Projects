import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Körpergewicht in Kilo angeben: ");
        double G = scanner.nextDouble();

        System.out.println("Bitte Körpergröße in Meter angeben: ");
      double h = scanner.nextDouble();

      double BMI = G / (h * h);

        System.out.println("Dein BMI ist: " + BMI);

        if (!(BMI <= 20)) {
            if (BMI >= 20 && BMI <= 25) {
                System.out.println("Sie haben Normalgewicht!");
            } else if (BMI >= 25 && BMI <= 30) {
                  System.out.println("Sie haben Übergewicht!");
            } else if (BMI >= 30 && BMI <= 40) {
                System.out.println("Sie haben starkes Übergewicht!");
            } else if (BMI >= 40) {
                System.out.println("Sie haben extremes Übergewicht!");
            }
        } else {
          System.out.println("Sie haben Untergewicht!");
      }


    }
}