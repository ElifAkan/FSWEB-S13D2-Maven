package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));

        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));

        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(-12));

    }
    public static boolean isPalindrome(int number) {
        int originalNumber = Math.abs(number);
        int reverse = 0;
        int temp = originalNumber;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reverse = (reverse * 10) + lastDigit;
            temp /= 10;
        }

        return originalNumber == reverse;
    }
    public static boolean isPerfectNumber(int number){
        if (number < 0)
            return false;

        int total = 0;
        for (int i = 1;  i<= number / 2; i++){
            if (number % i == 0){
                total += i;
            }
        }
        return number == total;
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        StringBuilder wordRepresentation = new StringBuilder();
        int reversedNumber = reverse(number);
        int originalNumberDigitCount = getDigitCount(number);
        int reversedNumberDigitCount = getDigitCount(reversedNumber);

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;
            wordRepresentation.append(getDigitInWords(lastDigit)).append(" ");
            reversedNumber /= 10;
        }

        for (int i = 0; i < (originalNumberDigitCount - reversedNumberDigitCount); i++) {
            wordRepresentation.append("Zero ");
        }

        return wordRepresentation.toString().trim();
    }

    public static int reverse(int number) {
        int reverse = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static String getDigitInWords(int digit) {
        switch (digit) {
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }


}
