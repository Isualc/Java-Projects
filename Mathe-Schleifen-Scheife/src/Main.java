import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculations(scanner);
    }

    private static void calculations(Scanner scanner) {
        while (true) {
            int input;
            while (true) {
                System.out.print("Enter Integer from 1 to 99.999.999: ");
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    if (input >= 1 && input < 2147483647) {   // Der maximale Wert von int
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter an Integer between 1 and 99.999.999.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an Integer between 1 and 99.999.999.");
                    scanner.next();
                }
            }

            int result = input * 3 + 1;
            int count = 1;

            do {
                System.out.println(result);
                if (result % 2 == 0) {
                    result = result / 2;
                } else {
                    result = result * 3 + 1;
                }
                count++;

            } while (result != 1);

            System.out.print("""
                1
                4
                2
                1
                infinity loop...
                """);
            System.out.println(count + " calculations before infinity loop");

            System.out.print("Wanna try another Integer from 1 to 99.999.999? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes" )) {
                System.out.println("END");
                break;
            }
        }
    }
}

