package mathoperator;

import dayofweek.DayOfWeek;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an operand");
        String input = scanner.nextLine().toUpperCase();

        Operators operand;

        try {
            operand = Operators.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operand entered.");
            return;
        }
        System.out.println("Enter an operand");
        int input1= scanner.nextInt();
        System.out.println("Enter an operand");
        int input2= scanner.nextInt();
        IntMath calculator = new IntMath();
        System.out.println(calculator.calculate(operand,input1,input2));
        scanner.close();
    }
}