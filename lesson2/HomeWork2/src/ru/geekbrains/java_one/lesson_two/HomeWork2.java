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

    private static int[] fillArray(int dimention) {

        int[] array = new int[dimention];
        for(int i = 0; i < dimention; i++) {
            array[i] = 1 + 3 * i;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0};
        revertArray(array);
        System.out.println(Arrays.toString(array));
    }
}