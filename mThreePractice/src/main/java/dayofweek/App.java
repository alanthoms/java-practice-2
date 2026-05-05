package dayofweek;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a day of the week:");
        String input = scanner.nextLine().toUpperCase();

        DayOfWeek day;

        try {
            day = DayOfWeek.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day entered.");
            return;
        }

        switch (day) {
            case MONDAY:
                System.out.println("4 days until Friday");
                break;
            case TUESDAY:
                System.out.println("3 days until Friday");
                break;
            case WEDNESDAY:
                System.out.println("2 days until Friday");
                break;
            case THURSDAY:
                System.out.println("1 day until Friday");
                break;
            case FRIDAY:
                System.out.println("It's Friday!");
                break;
            case SATURDAY:
                System.out.println("6 days until Friday");
                break;
            case SUNDAY:
                System.out.println("5 days until Friday");
                break;
        }

        scanner.close();
    }
}