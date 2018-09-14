package days.third;

import java.util.Scanner;

public class MyMainCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Iveskite skaicius ir zenkla tarp ju pvz: '10 + 10'");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] items = line.split(" ");

        if (items.length == 3) {
            int numb = Integer.parseInt(items[0]);
            int numb2 = Integer.parseInt(items[2]);
            String action = items[1];

            switch (action) {
                case "+":
                    int sum = calculator.sum(numb, numb2);
                    System.out.println("Suma " + sum);
                    break;
                case "-":
                    break;
                case "/":
                    break;
                default:
                    break;
            }

        } else {
            System.out.println("Ir ka tu cia darai?");
        }

    }
}
