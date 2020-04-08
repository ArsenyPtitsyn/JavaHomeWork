package ru.geekbrains.java_one.lesson_two;

import java.util.Arrays;

public class HomeWork2 {

    private static int[] revertArray(int[] array) {

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    private static int[] fillArray(int[] array) {

        for(int i = 0; i < array.length; i++) {
            array[i] = 1 + 3 * i;
        }
        return array;
    }

    private static int[] changeArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = (array[i] < 6) ? array[i] * 2 : array[i];
        }
        return array;
    }

    private static int maxOfArray(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            max = (array[i] > max) ? array[i] : max;
        }
        return max;
    }

    private static int minOfArray(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            min = (array[i] < min) ? array[i] : min;
        }
        return min;
    }

    private static int[][] fillDiagonalElementsOfSquareArray(int dimension) {
        int[][] array = new int[dimension][dimension];
        for(int i = 0; i < array.length; i++) {
             array[i][i] = 1;
        }
        return array;
    }

    private static boolean checkBalance(int[] array) {

        int sum = 0;
        for(int i = 0; i < array.length; i++)
            sum += array[i];

        for(int j = 0; j < array.length -1; j++) {
            int sumOfPartOne = 0;
            for(int k = 0; k <= j; k++) {
                sumOfPartOne += array[k];
            }
            if(2 * sumOfPartOne == sum) return true;
            else continue;
        }
        return false;
    }


    public static void main(String[] args) {

        final int[] array = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0};
        revertArray(array);
        System.out.println(Arrays.toString(array));

        int[] arr = new int[8];
        fillArray(arr);
        System.out.println(Arrays.toString(arr));

        final int[] chArr = {13, 3, 6, 5, 31, 4, 1, 0, -4};
        changeArray(chArr);
        System.out.println(Arrays.toString(chArr));

        final int[] extremumArr = {123, 2, -5, 13, 321, -16, 34, 57, 234};
        System.out.println("Максимумом и минимумом данного массива являются: " + maxOfArray(extremumArr) +
                " и " + minOfArray(extremumArr) + ", соответственно.");

        final int dimention = 7;
        int[][] diagonalArr = fillDiagonalElementsOfSquareArray(dimention);
        for(int i = 0; i < diagonalArr.length; i++) {
            for(int j = 0; j < diagonalArr.length; j++)
                System.out.print(diagonalArr[i][j] + "\t");
            System.out.println();
        }

        final int[] checkArr = {1,2,3,5,8,3,16};
        System.out.println("В данном массиве есть место, в котором сумма левой и правой части массива равны: "
        + checkBalance(checkArr));
    }
}