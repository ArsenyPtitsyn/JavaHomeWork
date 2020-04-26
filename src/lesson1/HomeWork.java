package lesson1;

public class HomeWork {
    public static void main(String[] args) {
        final int varOne = 13;
        final int varTwo = 17;
        final int varThree = 37;
        final int varFour = 97;

        final float fOne = 13f;
        final float fTwo = 17f;
        final float fThree = 37f;
        final float fFour = 97.0f;

        // Вызов метода doMath
        System.out.printf("Результат выполнения метода doMath: %.2f \n", + doMath(varOne, varTwo, varThree, varFour));
        System.out.printf("Результат выполнения переопределённого метода doMath: %.2f \n",
                + doMath(fOne, fTwo, fThree, fFour));
        System.out.println("Сумма двух чисел находится в нужном диапазоне? " + checkSum(-5, 20));
        System.out.println("Ваше число - " + (isPositive(-20) ? "положительно" : "отрицательно") + "!");
        System.out.println(greetings("Arseny"));
        System.out.println("Заданный год високосный? " + isLeapYear(2000));
    }

    private static float doMath(int a, int b, int c, int d) {
        return a * (b + (1f * c / d));
    }

    private static float doMath(float a, float b, float c, float d) {
        if (d == 0) return 0;
        return a * (b + (c * 1f / d));
    }

    private static boolean checkSum(int x, int y) {
        int sum = x + y;
        return sum <= 20 && sum >= 10;
    }

    private static boolean isPositive(int a) {
        return a >= 0;
    }

    private static String greetings(String name) {
        return "Привет, " + name + "!";
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}
