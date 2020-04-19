package lesson2;

import java.util.Arrays;

public class HomeWork2 {

    private static int[] revertArray(int[] array) {

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    private static void arithmeticProgression(int[] a, int shift, int step) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (i * step) + shift;
        }
    }

    private static void doubling(int[] array){
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
    }

    private static int maxOfArray(int[] array) {
        int max = array[0];
        for(int oneElementOfThisArray : array) {
            if(oneElementOfThisArray > max)
                max = oneElementOfThisArray;
        }
        return max;
    }

    private static int minOfArray(int[] array) {
        int min = array[0];
        for (int oneElementOfThisArray : array)
            if (oneElementOfThisArray < min)
                min = oneElementOfThisArray;

        return min;
    }

    private static void fillDiagonalElementsOfSquareArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[i][a.length - 1 - i] = 1;
        }
    }

    private static boolean checkBalance(int[] a) {
        int left = 0;
        for (int i = 0; i < a.length - 1; i++) {
            left += a[i];
            int right = 0;
            for (int j = i + 1; j < a.length; j++) {
                right += a[j];
                if (left == right) return true;
            }
        }
        return false;
    }

    private static int[] slideArrayUsingAdditionalArray(int[] array, int offset) {

        int[] additionalArray = new int[array.length];
        int remainder; // actual offset (<= array.length)

        if(offset < 0)
            remainder = offset % array.length + array.length;
        else
            remainder = offset % array.length;

        for(int i = 0; i < array.length; i++) {
            if(i < remainder)
                additionalArray[i] = array[array.length-remainder+i];
            else
                additionalArray[i] = array[i - remainder];
        }
        return additionalArray;
    }

    private static void shifter(int[] a, int n) {
        boolean dir = n < 0;
        if (dir) n = -n;
        n %= a.length;
        int lastIndex = a.length - 1;
        for (int i = 0; i < n; i++) {
            int temp = (dir) ? a[0] : a[lastIndex];
            if (dir) {
                System.arraycopy(a, 1, a, 0, lastIndex);
                a[lastIndex] = temp;
            } else {
                System.arraycopy(a, 0, a, 1, lastIndex);
                a[0] = temp;
            }
        }
    }

    private static void shifter1(int[] array, int value) {
        boolean dir = value < 0;
        if (dir) value = -value;

        value %= array.length;
        int shift = (dir) ? array.length - value : value;

        for (int i = 0; i < shift; i++) {
            int temp = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
    }

    public static void main(String[] args) {

        final int[] array = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0};
        revertArray(array);
        System.out.println(Arrays.toString(array));

        int[] arr1 = new int[8];
        arithmeticProgression(arr1, 1, 3);
        System.out.println(Arrays.toString(arr1));

        final int[] arr2 = {13, 3, 6, 5, 31, 4, 1, 0, -4};
        doubling(arr2);
        System.out.println(Arrays.toString(arr2));

        final int[] arr3 = {123, 2, -5, 13, 321, -16, 34, 57, 234};
        System.out.println("Максимумом и минимумом данного массива являются: " + maxOfArray(arr3) +
                " и " + minOfArray(arr3) + ", соответственно.");

        final int dimention = 10;
        int[][] diagonalArr = new int[dimention][dimention];
        fillDiagonalElementsOfSquareArray(diagonalArr);
        for (int i = 0; i < diagonalArr.length; i++) {
            System.out.println(Arrays.toString(diagonalArr[i]));
        }

        final int[] checkArr = {1,2,3,5,8,3,16};
        System.out.println("В массиве " + Arrays.toString(checkArr) +
                " есть место, в котором сумма левой и правой части массива равны: "
                + checkBalance(checkArr));

        final int[] slideArr = {17, 14, 34, 25, 64, 12, 58, 33, 1, 2};
        System.out.println("После циклической перестановки: " +
                Arrays.toString(slideArrayUsingAdditionalArray(slideArr, -57)));
        shifter(slideArr, -57);
        System.out.println("После циклической перестановки: " +
                Arrays.toString(slideArr));
        shifter(slideArr, -2);
        System.out.println("После циклической перестановки: " +
                Arrays.toString(slideArr));
    }
}