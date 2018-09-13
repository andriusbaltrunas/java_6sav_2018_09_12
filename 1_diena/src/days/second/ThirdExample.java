package days.second;

import java.util.Scanner;

public class ThirdExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite ugi");
        double ugis = sc.nextDouble();
        System.out.println("Iveskite svori");
        double svoris = sc.nextDouble();
        System.out.println("KMI YRA " + kmi(ugis, svoris));
    }

    private static double kmi(double ugis, double svoris){
        double kmi = svoris/Math.pow(ugis, 2);
        return kmi;
    }
}
