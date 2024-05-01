package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static void main(String[] args) {
        String inputDate = "Fri Apr 26 2024";
        boolean isInputDateOlderThanCurrentDate = isDateOlderThanCurrentDate(inputDate);
        System.out.println("Is the input date older than the current date? " + isInputDateOlderThanCurrentDate);
    }

    public static boolean isDateOlderThanCurrentDate(String dateString) {
        // Define the date format of the input date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy");


        // Parse the input date string into a LocalDate object
        LocalDate inputDate = LocalDate.parse(dateString, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Compare the parsed input date with the current date
        return inputDate.isBefore(currentDate);
    }
}
