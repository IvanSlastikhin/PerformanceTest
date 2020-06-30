package ru.jhonsy.home;

import java.util.Arrays;

/**
 * @Author: Ivan Slastikhin
 */
public class RecursiveMergeSortImpl {

    public static void main(String[] args) {

        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};

        recursiveMergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    public static void recursiveMergeSort(int[] array, int start, int end) {
        int middle = 0;
        if (start < end) {
            middle = (start + end) / 2;
            recursiveMergeSort(array, start, middle);
            recursiveMergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end) {
        // временный массив для хранения результатов слияния
        int[] temp_array = new int[end - start + 1];
        //индекс для прохода по "Первому" массиву
        int index_1 = start;
        //индекс для прохода по "Второму" массиву
        int index_2 = middle + 1;
        //индекс начала записи во временный массив
        int temp_index = 0;
        //пока не достигнуты концы слиаемых массивов
        while ((index_1 <= middle) || (index_2 <= end)) {
            //если достигнут конец первого массива,
            //то дописываем "хвост" второго массива во временный массив
            if (index_1 > middle) {
                temp_array[temp_index++] = array[index_2++];
                continue;
            }
            //если достигнут конец второго массива,
            //то дописываем "хвост" первого массива во временный массив
            if (index_2 > end) {
                temp_array[temp_index++] = array[index_1++];
                continue;
            }
            //сравниваем текущие элементы сливаемых массивов и записываем наименьший
            //во временный массив
            if (array[index_1] < array[index_2]) {
                temp_array[temp_index++] = array[index_1++];
                continue;
            } else {
                temp_array[temp_index++] = array[index_2++];
            }
        }
        //записываем отсортированный массив
        for (int i = 0; i < end - start + 1; i++) {
            array[i + start] = temp_array[i];
        }
    }
}
