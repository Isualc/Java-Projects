import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the cuboid: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the cuboid: ");
        double width = scanner.nextDouble();

        System.out.print("Enter the height of the cuboid: ");
        double height = scanner.nextDouble();

        double sumOfEdgeLengths = calculateSumOfEdgeLengths(length, width, height);
        double surfaceArea = calculateSurfaceArea(length, width, height);
        double volume = calculateVolume(length, width, height);

        System.out.println("Sum of edge lengths: " + sumOfEdgeLengths);
        System.out.println("Surface area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }

    private static double calculateSumOfEdgeLengths(double length, double width, double height) {
        return 4 * (length + width + height);
    }

    private static double calculateSurfaceArea(double length, double width, double height) {
        return 2 * (length * width + width * height + height * length);
    }

    private static double calculateVolume(double length, double width, double height) {
        return length * width * height;
    }
}