package exam.common;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class MyValidation {
    public static boolean isValidName(String name) {
        if (name == null) return false;
        name = name.trim();
        String regex = "^[A-Za-z]+(\\s[A-Za-z]+)*$";
        return Pattern.matches(regex, name);
    }

    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        email = email.trim();
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        phone = phone.trim();
        String regex = "^(0|\\+84)(3|5|7|8|9)\\d{8}$";
        return Pattern.matches(regex, phone);
    }

    public static boolean isValidAge(LocalDate birthday, int minAge, int maxAge) {
        if (birthday == null) return false;
        LocalDate now = LocalDate.now();
        if (birthday.isAfter(now)) {
            return false;
        }
        int age = Period.between(birthday, now).getYears();
        return age >= minAge && age <= maxAge;
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidFormatBirthday(String birthday) {
        String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        if (!Pattern.matches(regex, birthday)) {
            return false;
        }
        String[] birthdays = birthday.split("/");
        int day = Integer.parseInt(birthdays[0]);
        int month = Integer.parseInt(birthdays[1]);
        int year = Integer.parseInt(birthdays[2]);

        if (day <= 0 || month <= 0 || month > 12) {
            return false;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day <= 31;

            case 4:
            case 6:
            case 9:
            case 11:
                return day <= 30;

            case 2:
                if (isLeapYear(year)) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
        }
        return false;

    }
}
