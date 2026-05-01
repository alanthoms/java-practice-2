package dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class birthday {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO BIRTHDATY MAGICAL CALCUALTOR");
        System.out.println("WHATS YOUR BIRTHDAY");
        String birthDay = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate  = LocalDate.parse(birthDay, formatter);

        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();
        System.out.println("Your birthday was on a  " + dayOfWeek);

        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();

        LocalDate birthdayThisYear = birthDate.withYear(currentYear);
        DayOfWeek dayOfThisYear = birthdayThisYear.getDayOfWeek();

        System.out.println("Your birthday this year is on a  " + dayOfThisYear);

        System.out.println("Today is " + today);

        LocalDate nextBirthday = birthdayThisYear;


        if (!nextBirthday.isAfter(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        Period diff = today.until(nextBirthday);

        System.out.println("Time until your next birthday: "
                + diff.getMonths() + " months and "
                + diff.getDays() + " days");

        // 5. Age on next birthday
        int ageNext = Period.between(birthDate, nextBirthday).getYears();
        System.out.println("You will be " + ageNext + " years old");

        input.close();




    }
}
