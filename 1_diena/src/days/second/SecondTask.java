package days.second;

import java.util.Scanner;

public class SecondTask {

    public static void main(String[] args) {

        System.out.println("Pasirinkite ka norite skaiciuoti" +
                "\n1-statciojo trikampio plotas\n2-staciakmapio plotas\n3-kvadrato plotas" +
                "\n4-apskirtimo plotas");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                //double result = triangle(scanner);
                System.out.println("Trikampio plotas yra " + triangle(scanner));
                break;
            case 2:
                //TODO call method
                break;
            case 3:
                //TODO call method
                break;
            case 4:
                //TODO call method
                break;
            default:
                System.out.println("Netiko nei vienas");
                break;
        }
    }

    private static double triangle(Scanner scanner) {
        System.out.print("Iveskite a statini");
        double a = scanner.nextDouble();
        System.out.println("Iveskite b statini");
        double b = scanner.nextDouble();
        return (a * b) / 2;
    }

}
