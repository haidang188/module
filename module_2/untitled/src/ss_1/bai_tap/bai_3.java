package ss_1.bai_tap;

import java.util.Scanner;

public class bai_3 {

    private static String readOneDigit(int n) {
        switch (n) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    private static String readTeen(int n) {
        switch (n) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";

        }
    }

    private static String readTwoDigit(int n) {
        int tens = n / 10;
        int ones = n % 10;

        String tensWord = "";
        switch (tens) {
            case 2:
                tensWord = "twenty";
                break;
            case 3:
                tensWord = "thirty";
                break;
            case 4:
                tensWord = "forty";
                break;
            case 5:
                tensWord = "fifty";
                break;
            case 6:
                tensWord = "sixty";
                break;
            case 7:
                tensWord = "seventy";
                break;
            case 8:
                tensWord = "eighty";
                break;
            case 9:
                tensWord = "ninety";
                break;
        }
        if (ones == 0) return tensWord;
        return tensWord + " " + readOneDigit(ones);
    }
    private static String readThreeDigits(int n) {
        int hundreds = n / 100;
        int remainder = n % 100;

        String result = readOneDigit(hundreds) + "hundred";
        if (remainder == 0) return result;

        String tail;
        if (remainder < 10) tail = readOneDigit(remainder);
        else if (remainder < 20) tail = readTeen(remainder);
        else tail = readTwoDigit(remainder);

        return result + " and " + tail;
    }
    private static String readNumber(int n) {
        if (n < 0 || n > 999) return "out of ability";
        if (n < 10) return readOneDigit(n);
        if (n < 20) return readTeen(n);
        if (n < 100) return readTwoDigit(n);
        return readThreeDigits(n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so can doc: ");
        int number = sc.nextInt();
        System.out.println(readNumber(number));
        sc.close();
    }

}



