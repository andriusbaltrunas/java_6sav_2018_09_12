package days.second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThirdExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ugis = getCorrectNumb(sc, "Iveskite ugi");
        double svoris = getCorrectNumb(sc, "Iveskite svori");
        System.out.println("KMI YRA " + kmi(ugis, svoris));
    }

    private static double kmi(double ugis, double svoris) {
        double kmi = svoris / Math.pow(ugis, 2);
        return kmi;
    }

    private static double getCorrectNumb(Scanner sc, String text) {
        System.out.println(text);
        double val = 0;
        while (true) {
            try {
                val = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Blogai ivestas skaicius pakartokite");
                sc.nextLine();
            }
        }
        return val;
    }
}
