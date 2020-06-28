package ru.jhonsy.home;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Ivan Slastikhin
 */
public class LinkedListAndArrayListPerformanceTest {

    private static final int LIST_SIZE = 1000000;
    private static final int NUMBER_OF_ITERATIONS = 10000;

    private static List<Integer> linkedList = new LinkedList<>();
    private static List<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        Random random = new Random();

        //Производительность вставки в конец списка

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LIST_SIZE; i++) {
            linkedList.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("Adding " + LIST_SIZE + " random values to LinkedList took: "
                + ((double) (System.currentTimeMillis() - startTime)) + " ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < LIST_SIZE; i++) {
            arrayList.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("Adding " + LIST_SIZE + " random values to ArrayList took: "
                + ((double) (System.currentTimeMillis() - startTime)) + " ms");

        System.out.println("==============================================================");

        //Производительность получения значений на i-ой позиции

        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            linkedList.get(i);
        }
        System.out.println("Getting " + NUMBER_OF_ITERATIONS + " values at position i from LinkedList took: "
                + ((double) (System.currentTimeMillis() - startTime)) + " ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            arrayList.get(i);
        }
        System.out.println("Getting " + NUMBER_OF_ITERATIONS + " values at position i from ArrayList took: "
                + ((double) (System.currentTimeMillis() - startTime)) + " ms");

        System.out.println("==============================================================");

        //Производительность удалений элементов с i-ой позиции

        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            linkedList.remove(i);
        }
        System.out.println("Removing " + NUMBER_OF_ITERATIONS + " values at position i from LinkedList took: "
                + ((double) (System.currentTimeMillis() - startTime)) + " ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            arrayList.remove(i);
        }
        System.out.println("Removing " + NUMBER_OF_ITERATIONS + " values at position i from ArrayList took: "
                + ((double) (System.currentTimeMillis() - startTime)) + " ms");

        System.out.println("==============================================================");

    }
}
