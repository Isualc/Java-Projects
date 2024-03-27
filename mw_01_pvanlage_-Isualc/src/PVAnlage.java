/**
 * KLASSENHEADER
 * Name Claus Hierzer
 * Datum 21.07.2023
 * Version 20.001
 * Beschreibung
 *The programm calculate the Break-Even-Point, the performance, the earnings and costs of a PV-System.
 *
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class PVAnlage {
    public static void main(String[] args) {
        // Add your code here
        int n_modules;
        double subsidy;
        int direction;
        double rate;
        final double y_spez = 905.0;
        final double price_per_module = 259.99;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        // Input loop for the number of solar modules
        while(true){
            System.out.print("Number of solar modules: ");
            n_modules = scanner.nextInt();
            if (n_modules < 1 || n_modules > 80) {
                System.out.print("Invalid input! The number of solar modules must be an integer " +
                        "greater than or equal to 1 and less than or equal to 80.\n");
                continue;
            }
            break;
        }
        // Input loop for the subsidy percentage
        while (true) {
            System.out.print("Subsidy in % of the investment: ");
            subsidy = scanner.nextDouble();
            if (subsidy < 0 || subsidy > 100) {
                System.out.print("Invalid input! The subsidy must be an integer " +
                        "greater than or equal to 0 and less than or equal to 100.\n");
                continue;
            }
            break;
        }
        // Prompt an input for the PV system direction
        System.out.println("Direction of the photovoltaic system: ");
        System.out.println("1: SOUTH");
        System.out.println("2: SOUTH-EAST");
        System.out.println("3: EAST");
        System.out.println("4: SOUTH-WEST");
        System.out.println("5: WEST");

        // Input loop for the direction
        while (true) {
            System.out.print("Please enter the direction: ");
            direction = scanner.nextInt();
            if (direction < 1 || direction > 5) {
                continue;
            }
            break;
        }

        double prozent_faktor = 0;
        String direction_word = switch (direction) {
            // Direction cases
            case 1 -> {
                prozent_faktor = 1;
                yield "SOUTH";
            }
            case 2 -> {
                prozent_faktor = 0.95;
                yield "SOUTH-EAST";
            }
            case 3 -> {
                prozent_faktor = 0.9;
                yield "EAST";
            }
            case 4 -> {
                prozent_faktor = 0.95;
                yield "SOUTH-WEST";
            }
            case 5 -> {
                prozent_faktor = 0.9;
                yield "WEST";
            }
            default -> "";
        };
        // Input loop for the electricity rate
        while (true) {
            System.out.print("Electricity rate in cents/kWh: ");
            rate = scanner.nextDouble();
            if (rate <= 0 || rate >= 101) {
               System.out.println("Invalid input! The electricity rate must be an integer " +
                       "which is at least 1 and must not exceed 100 cents/kWh.");
               continue;
           }
           break;
       }
        // Output section beginns here
        System.out.println(n_modules + " modules facing " + direction_word + ".");

        // ... Calculations
        double achievable_total_power = 0.375 * n_modules;
        double actual_totalPower = 0.375 * prozent_faktor * n_modules;
        double costs = price_per_module * n_modules;

        String formattedAchievableTotalPower = df.format(achievable_total_power);
        String formattedActualTotalPower = df.format(actual_totalPower);
        String formattedCosts = df.format(costs);

        System.out.println("Achievable total power: " + formattedAchievableTotalPower + " kWp.");

        if(direction != 1) {
            System.out.println("However, due to the suboptimal direction, only "
                    + formattedActualTotalPower + " kWp are achieved.");
        }
        double y = y_spez * actual_totalPower;
        double earnings = y * (rate / 100);
        String formattedEarnings = df.format(earnings);

        System.out.println("Investment of " + formattedCosts + " leads to earnings of "
                + formattedEarnings + " each year.");

        int year = 1;
        double costs_to_compensate = costs;
        double subsidy_in_euro = costs * (subsidy / 100);
        // ... More calculations

        // Amortization loop
        while(true) {
            costs_to_compensate = costs_to_compensate - earnings;
            if(costs_to_compensate <= 0) {
                break;
            }
            if(subsidy > 0 && year == 1) {
                costs_to_compensate = costs_to_compensate - subsidy_in_euro;
                if(costs_to_compensate <= 0) {
                    break;
                }
                String formattedCostToCompensate = df.format(costs_to_compensate);
                String formattedSubsidyInEuro = df.format(subsidy_in_euro);
                System.out.println("After year " + year + ": " + formattedCostToCompensate + " still to compensate. "
                                     + "(" + formattedSubsidyInEuro + " paid by the government)");
            }
            else {
                String formattedCostToCompensate = df.format(costs_to_compensate);
                System.out.println("After year " + year + ": " + formattedCostToCompensate + " still to compensate.");
            }
            year++;
        }
        // Output amortization period
        if(year == 1){
            System.out.println("PV system amortized within a year.");
        }
        else {
            System.out.println("PV system amortized within " + year + " years.");
        }
    }
}

