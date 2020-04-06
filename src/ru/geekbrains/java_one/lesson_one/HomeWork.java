package ru.geekbrains.java_one.lesson_one;

public class HomeWork {
    public static void main(String[] args) {
        // Вызов метода doMath
        double res = doMath(13, 17, 37, 97);
        System.out.println("Результат выполнения метода doMath: " + res); // Проверка метода doMath

        // Вызов метода checkSum с проверкой результатов для нескольких случаев...
        boolean rangeOfSum = checkSum(12, 5);
        System.out.println("Рузультат выполнения метода checkSum(12, 5): " + rangeOfSum);
        rangeOfSum = checkSum(3, 5);
        System.out.println("Рузультат выполнения метода checkSum(3, 5): " + rangeOfSum);
        rangeOfSum = checkSum(-12, 25);
        System.out.println("Рузультат выполнения метода checkSum(-12, 25): " + rangeOfSum);
        rangeOfSum = checkSum(-12, 0);
        System.out.println("Рузультат выполнения метода checkSum(-12, 0): " + rangeOfSum);

        // Вызов метода isPositive с проверкой результатов для нескольких случаев...
        System.out.println("Число 5 положительно: " + isPositive(5));
        System.out.println("Число 0 положительно: " + isPositive(0));
        System.out.println("Число 5 положительно: " + isPositive(-3));

        // Вызов метода greetings...
        greetings("Арсений");
        greetings("Иван");

        // Вызов метода isLeapYear и проверка результатов для нескольких вариантов
        System.out.println("1300 год является високосным: " + isLeapYear(1300));
        System.out.println("2048 год является високосным: " + isLeapYear(2048));
        System.out.println("2047 год является високосным: " + isLeapYear(2047));
        System.out.println("2100 год является високосным: " + isLeapYear(2100));
        System.out.println("1500 год является високосным: " + isLeapYear(1500));
        System.out.println("1400 год является високосным: " + isLeapYear(1400));
        System.out.println("2000 год является високосным: " + isLeapYear(2000));
    }

    private static double doMath(int a, int b, int c, int d) {
        double result = a * (b + (1.0 * c / d));
        return result;
    }

    private static boolean checkSum(int x, int y) {
        boolean isSumCorrect = ((x + y >= 10) && (x + y <= 20));
        return isSumCorrect;
    }

    private static boolean isPositive(int a) {
        boolean bool = a >= 0;
        return bool;
    }

    private static void greetings(String name) {
        System.out.println("Привет, " + name);
    }

    private static boolean isLeapYear(int year) {
        boolean isLeap = ((year % 4 == 0) && !(year % 400 == 100) && !(year % 400 == 200) && !(year % 400 == 300));
        return isLeap;
    }
}
