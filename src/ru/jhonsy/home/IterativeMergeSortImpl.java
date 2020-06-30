package ru.jhonsy.home;

import java.util.Arrays;

/**
 * @Author: Ivan Slastikhin
 */
public class IterativeMergeSortImpl {

    public static void main(String[] args) {

        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};

        System.out.println(Arrays.toString(mergeSort(array)));

    }



    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] current = array;
        int[] result = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                iterativeMerge(current, i, current, i + size, result, i, size);
            }

            tmp = current;
            current = result;
            result = tmp;

            size = size * 2;

        }

        return current;
    }

    public static void iterativeMerge(int[] src1, int srcStart1,
                                      int[] src2, int srcStart2,
                                      int[] result, int resultStart, int size) {
        //переменная для прохода по первому массиву
        int index1 = srcStart1;
        //переменная для прохода по второму массиву
        int index2 = srcStart2;

        //индекс конца первого массива
        int srcEnd1 = Math.min(srcStart1 + size, src1.length);
        //индекс конца второго массива
        int srcEnd2 = Math.min(srcStart2 + size, src2.length);
        //число итераций
        int iterationsCount = (srcEnd1 - srcStart1) + (srcEnd2 - srcStart2);

        for (int i = resultStart; i < resultStart + iterationsCount; i++) {
            //проверяем, что не добрались до конца сливаемых массивов
            if (index1 < srcEnd1 && (index2 >= srcEnd2 || (src1[index1] < src2[index2]))) {
                result[i] = src1[index1];
                index1++;
            } else {
                result[i] = src2[index2];
                index2++;
            }
        }
    }
}
