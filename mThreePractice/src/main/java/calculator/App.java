package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SimpleCalculator simpleCalculator = new SimpleCalculator();

        System.out.println("pick what you want to do , 1 for add, 2 for sub, 3 for mult ,4 for div");
        int choice =  sc.nextInt();
        System.out.println("enter the first number");
        double a = sc.nextDouble();
        System.out.println("enter the second number");
        double b = sc.nextDouble();
        double res = 0;

        switch (choice) {
            case 1:
                res = simpleCalculator.add(a, b);
                break;
            case 2:
                res = simpleCalculator.sub(a, b);
                break;
            case 3:
                res = simpleCalculator.mul(a, b);
                break;
            case 4:
                res = simpleCalculator.div(a, b);
                break;
            default:
                System.out.println("invalid choice");

        }

        System.out.println(res);
    }


}
