package ru.geekbrains.java_one.lesson_one;

public class HomeWork {
    public static void main(String[] args) {
        // Вызов метода doMath
        double res = doMath(13, 17, 37, 97);
        System.out.println("Результат выполнения метода doMath: " + res); // Проверка метода doMath

        // Вызов метода checkSum с проверкой результатов для нескольких случаев...
        System.out.println("Результат выполнения метода checkSum(12, 5): " + checkSum(12, 5));
        System.out.println("Результат выполнения метода checkSum(3, 5): " + checkSum(3, 5));
        System.out.println("Результат выполнения метода checkSum(-12, 35): " + checkSum(-12, 35));
        System.out.println("Результат выполнения метода checkSum(-12, -5): " + checkSum(-12, -5));

        // Вызов метода signOfNumber с проверкой результатов для нескольких случаев...
        signOfNumber(5);
        signOfNumber(0);
        signOfNumber(-3);

        // Вызов метода greeting...
        greeting("Арсений");
        greeting("Иван");

        // Вызов метода isLeapYear и проверка результатов для нескольких вариантов
        isLeapYear(1300);
        isLeapYear(1200);
        isLeapYear(2048);
        isLeapYear(2047);
        isLeapYear(2100);
        isLeapYear(1500);
        isLeapYear(1400);
    }

    private static double doMath(int a, int b, int c, int d) {
        double result = a * (b + (c / d));
        return result;
    }

    private static boolean checkSum(int x, int y) {
        if ((x + y) >= 10 && (x + y) <= 20)
            return true;
        else
            return false;
    }

    private static void signOfNumber(int a) {
        if(a >= 0)
            System.out.println("Число " + a + " положительно!");
        else
            System.out.println("Число " + a + " отрицательно!");
    }

    private static void greeting(String name) {
        System.out.println("Привет, " + name);
    }

    private static void isLeapYear(int year) {
        if ((year % 4 == 0) && !(year % 400 == 100) && !(year % 400 == 200) && !(year % 400 == 300))
            System.out.println(year + " - високосный год!");
        else
            System.out.println(year + " не является високосным годом!");
    }
}
