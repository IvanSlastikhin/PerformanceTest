package ru.jhonsy.home;

import java.util.*;

/**
 * @Author: Ivan Slastikhin
 */
public class StreamTest {
    private static final int LIST_SIZE = 1000000;
    private static List<Integer> list = new ArrayList<>(LIST_SIZE);

    static
    {
        Random random = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).toString();
        }
        System.out.println(((double) (System.currentTimeMillis() - start) )  + " ms");
        System.out.println("=========================================================");

        start = System.currentTimeMillis();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.get(i).toString();
        }
        System.out.println(((double) (System.currentTimeMillis() - start))  + " ms");
        System.out.println("=========================================================");

        start = System.currentTimeMillis();
        for (Integer i:
             list) {
            i.toString();
        }
        System.out.println(((double) (System.currentTimeMillis() - start))  + " ms");
        System.out.println("=========================================================");

        start = System.currentTimeMillis();
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
            integerIterator.next().toString();
        }
        System.out.println(((double) (System.currentTimeMillis() - start))  + " ms");
        System.out.println("=========================================================");

        start = System.currentTimeMillis();
        list.stream()
                .forEach(integer -> integer.toString());
        System.out.println(((double) (System.currentTimeMillis() - start))  + " ms");
        System.out.println("=========================================================");

        start = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (Integer i : list){
            max = (i > max) ? i : max;
        }
        System.out.println(max);
        System.out.println(((double) (System.currentTimeMillis() - start))  + " ms");
        System.out.println("=========================================================");

        start = System.currentTimeMillis();
        IntSummaryStatistics stats = list.stream()
                .mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(((double) (System.currentTimeMillis() - start))  + " ms");
        System.out.println("=========================================================");
    }
}
