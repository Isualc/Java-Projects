import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Jahr angeben: ");
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            System.out.println(year + " ist ein Schaltjahr.");
        }else {
            System.out.println(year + " ist kein Schaltjahr.");
        }
    }
}